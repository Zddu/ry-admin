package com.ruoyi.survey.service.impl;

import java.util.List;
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
}