package com.ruoyi.survey.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfCreateFormMapper;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.service.IQfCreateFormService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@Service
public class QfCreateFormServiceImpl implements IQfCreateFormService 
{
    @Autowired
    private QfCreateFormMapper qfCreateFormMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfCreateForm selectQfCreateFormById(Long id)
    {
        return qfCreateFormMapper.selectQfCreateFormById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfCreateForm> selectQfCreateFormList(QfCreateForm qfCreateForm)
    {
        return qfCreateFormMapper.selectQfCreateFormList(qfCreateForm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfCreateForm(QfCreateForm qfCreateForm)
    {
        qfCreateForm.setCreateTime(DateUtils.getNowDate());
        return qfCreateFormMapper.insertQfCreateForm(qfCreateForm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfCreateForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfCreateForm(QfCreateForm qfCreateForm)
    {
        return qfCreateFormMapper.updateQfCreateForm(qfCreateForm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfCreateFormByIds(Long[] ids)
    {
        return qfCreateFormMapper.deleteQfCreateFormByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfCreateFormById(Long id)
    {
        return qfCreateFormMapper.deleteQfCreateFormById(id);
    }
}
