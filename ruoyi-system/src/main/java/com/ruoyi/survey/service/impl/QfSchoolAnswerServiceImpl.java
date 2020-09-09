package com.ruoyi.survey.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfKeyIndexAnswer;
import com.ruoyi.survey.mapper.QfKeyNameMapper;
import com.ruoyi.survey.mapper.QfUserFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfSchoolAnswerMapper;
import com.ruoyi.survey.domain.QfSchoolAnswer;
import com.ruoyi.survey.service.IQfSchoolAnswerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
@Service
public class QfSchoolAnswerServiceImpl implements IQfSchoolAnswerService{
    @Autowired
    private QfSchoolAnswerMapper qfSchoolAnswerMapper;
    @Autowired
    private QfUserFormMapper qfUserFormMapper;
    @Autowired
    private QfKeyNameMapper qfKeyNameMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfSchoolAnswer selectQfSchoolAnswerById(Long id)
    {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfSchoolAnswer> selectQfSchoolAnswerList(QfSchoolAnswer qfSchoolAnswer)
    {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerList(qfSchoolAnswer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer)
    {
        return qfSchoolAnswerMapper.insertQfSchoolAnswer(qfSchoolAnswer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer)
    {
        return qfSchoolAnswerMapper.updateQfSchoolAnswer(qfSchoolAnswer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfSchoolAnswerByIds(Long[] ids)
    {
        return qfSchoolAnswerMapper.deleteQfSchoolAnswerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfSchoolAnswerById(Long id)
    {
        return qfSchoolAnswerMapper.deleteQfSchoolAnswerById(id);
    }

    @Override
    public List<QfSchoolAnswer> selectQfSchoolAnswerListBySId(Long cid,Long sid) {
        return qfSchoolAnswerMapper.selectQfSchoolAnswerListBySId(cid,sid);
    }

    @Override
    public Map<String, Object> exportQfSchoolAnswer(Long cid) {
        Map<String,String> titleMap =new HashMap<>();
        Map<String,String> answerMap =new HashMap<>();
        List<String> titleList =new ArrayList<>();
        List<QfKeyName> keyNames = qfKeyNameMapper.selectQfKeyNameList(new QfKeyName(cid));
        for (QfKeyName keyName : keyNames) {
            titleMap.put(keyName.getKey(),keyName.getName());
            titleList.add(keyName.getName());
        }

        List<List<QfKeyIndexAnswer>> values =new ArrayList<>();

        for (QfUserForm qfUserForm:qfUserFormMapper.selectQfUserFormList(new QfUserForm(cid))){
            List<QfSchoolAnswer> qfSchoolAnswers = qfSchoolAnswerMapper.selectQfSchoolAnswerListBySId(cid, qfUserForm.getSchoolId().longValue());
            for (QfSchoolAnswer qfSchoolAnswer : qfSchoolAnswers) {
                QfKeyIndexAnswer answer = new QfKeyIndexAnswer();
                answer.setKeyIndex(
                        titleList.indexOf(
                                titleMap.get(qfSchoolAnswer.getKey().substring(qfSchoolAnswer.getKey().lastIndexOf("_")+1)
                                )
                        )
                );
                answer.setValue(qfSchoolAnswer.getValue());

            }
        }


        return null;
    }
}
