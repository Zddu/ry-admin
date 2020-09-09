package com.ruoyi.survey.service;

import java.util.List;

import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.domain.QfUserForm;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public interface IQfUserFormService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public QfUserForm selectQfUserFormById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<QfUserForm> selectQfUserFormList(QfUserForm qfUserForm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    public int insertQfUserForm(QfUserForm qfUserForm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfUserForm 【请填写功能名称】
     * @return 结果
     */
    public int updateQfUserForm(QfUserForm qfUserForm);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfUserFormByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfUserFormById(Long id);

    List<QfUserForm> selectQfSchoolFormList(Long id);

    int insertAnswer(String json, Long sid, Long cid);

    List<QfCreateForm> selectQfUserFormListBySId(QfCreateForm qfUserForm, Long id);
}
