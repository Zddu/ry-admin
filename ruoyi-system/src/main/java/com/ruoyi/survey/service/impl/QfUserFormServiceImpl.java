package com.ruoyi.survey.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfSchoolAnswer;
import com.ruoyi.survey.mapper.QfSchoolAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfUserFormMapper;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.service.IQfUserFormService;
import org.springframework.transaction.annotation.Transactional;

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
        QfUserForm qfUserForm = new QfUserForm(new Date(), 1);
        int result =qfUserFormMapper.updateQfUserForm(qfUserForm);

        Map parse = JSON.parseObject(json, Map.class);
        List<QfSchoolAnswer> keyNames=new ArrayList<>();

        for (Object o : parse.keySet()) {
            keyNames.add(new QfSchoolAnswer(qfUserForm.getId(),String.valueOf(o),String.valueOf(parse.get(o))));
        }
        for (QfSchoolAnswer keyName : keyNames) {
           result = qfSchoolAnswerMapper.insertQfSchoolAnswer(keyName);
        }
        return result;
    }
}
