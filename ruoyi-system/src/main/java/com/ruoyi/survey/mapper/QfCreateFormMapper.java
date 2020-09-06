package com.ruoyi.survey.mapper;

import java.util.List;
import com.ruoyi.survey.domain.QfCreateForm;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
public interface QfCreateFormMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteQfCreateFormById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQfCreateFormByIds(Long[] ids);
}
