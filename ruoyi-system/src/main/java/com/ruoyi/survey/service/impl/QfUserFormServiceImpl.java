package com.ruoyi.survey.service.impl;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfSchoolAnswer;
import com.ruoyi.survey.mapper.QfCreateFormMapper;
import com.ruoyi.survey.mapper.QfSchoolAnswerMapper;
import com.ruoyi.survey.util.QfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfUserFormMapper;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.service.IQfUserFormService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@Service
public class QfUserFormServiceImpl implements IQfUserFormService {
    @Autowired
    private QfUserFormMapper qfUserFormMapper;
    @Autowired
    private QfSchoolAnswerMapper qfSchoolAnswerMapper;
    @Autowired
    private QfCreateFormMapper qfCreateFormMapper;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfUserForm selectQfUserFormById(Long id)
    {
        return qfUserFormMapper.selectQfUserFormById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfUserForm> selectQfUserFormList(QfUserForm qfUserForm)
    {
        return qfUserFormMapper.selectQfUserFormList(qfUserForm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfUserForm(QfUserForm qfUserForm)
    {
        qfUserForm.setCreateTime(DateUtils.getNowDate());
        return qfUserFormMapper.insertQfUserForm(qfUserForm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfUserForm(QfUserForm qfUserForm)
    {
        return qfUserFormMapper.updateQfUserForm(qfUserForm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfUserFormByIds(Long[] ids)
    {
        return qfUserFormMapper.deleteQfUserFormByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfUserFormById(Long id)
    {
        return qfUserFormMapper.deleteQfUserFormById(id);
    }

    @Override
    public List<QfUserForm> selectQfSchoolFormList(Long id) {
        return qfUserFormMapper.selectQfSchoolFormList(id);
    }

    @Override
    @Transactional
    public int insertAnswer(String json, Long sid, Long cid) {
        QfCreateForm qfCreateForm = qfCreateFormMapper.selectQfCreateFormById(cid);
        QfUserForm qfUserForm = qfUserFormMapper.selectQfSchoolFormBySId(sid, cid);
        if(qfUserForm.getState()!=2){
            if (qfCreateForm.getEndTime().getTime()<new Date().getTime()){
                throw new CustomException("已截止");
            }
        }

        //插入表单必填项
        QfUtils.verificationRequired(qfCreateForm.getStrData());


        if (ObjectUtils.isEmpty(qfUserForm)){
            throw new CustomException("该角色没有表单提交权限");
        }
        qfUserForm.setCreateTime(new Date());
        qfUserForm.setState(1);
        int result =qfUserFormMapper.updateQfUserForm(qfUserForm);
        LinkedHashMap parse = JSON.parseObject(json, LinkedHashMap.class, Feature.OrderedField);
        List<QfSchoolAnswer> keyNames=new ArrayList<>();
        for (Object o : parse.keySet()) {
            keyNames.add(
                    new QfSchoolAnswer(
                            qfUserForm.getId(),
                            String.valueOf(o),
                            String.valueOf(parse.get(o)),
                            QfUtils.getValueType(parse, (String) o)
                    )
            );
        }
        List<QfSchoolAnswer> qfSchoolAnswers = qfSchoolAnswerMapper.selectAllQfSchoolAnswer();
        if (qfSchoolAnswers.indexOf(keyNames.get(0))==-1){
            for (QfSchoolAnswer keyName : keyNames) {
                result = qfSchoolAnswerMapper.insertQfSchoolAnswer(keyName);
            }
        }else{
            for (QfSchoolAnswer keyName : keyNames){
                result = qfSchoolAnswerMapper.updateQfSchoolAnswerByKeyAndSchool(keyName);
            }
        }

        return result;
    }

    @Override
    public List<QfCreateForm> selectQfUserFormListBySId(QfCreateForm qfUserForm, Long id) {
        //为了方便起见将状态字段换成了用户的提交状态
        List<QfCreateForm> qfCreateForms = qfCreateFormMapper.selectQfUserFormListBySId(qfUserForm, id);
        //将已截止的排序放在最后
        QfUtils.endTime2Last(qfCreateForms);
        //将已驳回的放在最前面
        return  QfUtils.rejected2Head(qfCreateForms);
    }
}
