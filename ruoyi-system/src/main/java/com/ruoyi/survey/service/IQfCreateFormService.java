package com.ruoyi.survey.service;

import java.text.ParseException;
import java.util.List;
import com.ruoyi.survey.domain.QfCreateForm;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public interface IQfCreateFormService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfCreateForm selectQfCreateFormById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfCreateForm> selectQfCreateFormList(QfCreateForm qfCreateForm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    public int insertQfCreateForm(QfCreateForm qfCreateForm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    public int updateQfCreateForm(QfCreateForm qfCreateForm);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfCreateFormByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfCreateFormById(Long id);



    int insertQuestionnaire(QfCreateForm qfCreateForm);
}