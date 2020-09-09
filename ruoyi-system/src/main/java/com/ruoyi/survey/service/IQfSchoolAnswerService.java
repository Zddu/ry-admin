package com.ruoyi.survey.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.survey.domain.QfSchoolAnswer;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
public interface IQfSchoolAnswerService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfSchoolAnswer selectQfSchoolAnswerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfSchoolAnswer> selectQfSchoolAnswerList(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    public int insertQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfSchoolAnswer 【请填写功能名称】
     * @return 结果
     */
    public int updateQfSchoolAnswer(QfSchoolAnswer qfSchoolAnswer);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfSchoolAnswerByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfSchoolAnswerById(Long id);

    List<QfSchoolAnswer> selectQfSchoolAnswerListBySId(Long cid,Long sid);

    Map<String, Object> exportQfSchoolAnswer(Long cid, Long selectParentDepByChildId);
}
