package com.ruoyi.survey.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfCreateModelMapper;
import com.ruoyi.survey.domain.QfCreateModel;
import com.ruoyi.survey.service.IQfCreateModelService;

/**
 * 发布问卷的模板Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-10-11
 */
@Service
public class QfCreateModelServiceImpl implements IQfCreateModelService 
{
    @Autowired
    private QfCreateModelMapper qfCreateModelMapper;

    /**
     * 查询发布问卷的模板
     * 
     * @param id 发布问卷的模板ID
     * @return 发布问卷的模板
     */
    @Override
    public QfCreateModel selectQfCreateModelById(Long id)
    {
        return qfCreateModelMapper.selectQfCreateModelById(id);
    }

    /**
     * 查询发布问卷的模板列表
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 发布问卷的模板
     */
    @Override
    public List<QfCreateModel> selectQfCreateModelList(QfCreateModel qfCreateModel)
    {
        return qfCreateModelMapper.selectQfCreateModelList(qfCreateModel);
    }

    /**
     * 新增发布问卷的模板
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 结果
     */
    @Override
    public int insertQfCreateModel(QfCreateModel qfCreateModel)
    {
        qfCreateModel.setCreateTime(DateUtils.getNowDate());
        return qfCreateModelMapper.insertQfCreateModel(qfCreateModel);
    }

    /**
     * 修改发布问卷的模板
     * 
     * @param qfCreateModel 发布问卷的模板
     * @return 结果
     */
    @Override
    public int updateQfCreateModel(QfCreateModel qfCreateModel)
    {
        return qfCreateModelMapper.updateQfCreateModel(qfCreateModel);
    }

    /**
     * 批量删除发布问卷的模板
     * 
     * @param ids 需要删除的发布问卷的模板ID
     * @return 结果
     */
    @Override
    public int deleteQfCreateModelByIds(Long[] ids)
    {
        return qfCreateModelMapper.deleteQfCreateModelByIds(ids);
    }

    /**
     * 删除发布问卷的模板信息
     * 
     * @param id 发布问卷的模板ID
     * @return 结果
     */
    @Override
    public int deleteQfCreateModelById(Long id)
    {
        return qfCreateModelMapper.deleteQfCreateModelById(id);
    }
}
