package com.ruoyi.survey.service;

import java.util.List;
import com.ruoyi.survey.domain.QfCreateModel;

/**
 * 发布问卷的模板Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-10-11
 */
public interface IQfCreateModelService 
{
    /**
     * 查询发布问卷的模板
     * 
     * @param id 发布问卷的模板ID
     * @return 发布问卷的模板
     */
    public QfCreateModel selectQfCreateModelById(Long id);

    /**
     * 查询发布问卷的模板列表
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 发布问卷的模板集合
     */
    public List<QfCreateModel> selectQfCreateModelList(QfCreateModel qfCreateModel);

    /**
     * 新增发布问卷的模板
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 结果
     */
    public int insertQfCreateModel(QfCreateModel qfCreateModel);

    /**
     * 修改发布问卷的模板
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 结果
     */
    public int updateQfCreateModel(QfCreateModel qfCreateModel);

    /**
     * 批量删除发布问卷的模板
     * 
     * @param ids 需要删除的发布问卷的模板ID
     * @return 结果
     */
    public int deleteQfCreateModelByIds(Long[] ids);

    /**
     * 删除发布问卷的模板信息
     * 
     * @param id 发布问卷的模板ID
     * @return 结果
     */
    public int deleteQfCreateModelById(Long id);
}
