package com.ruoyi.survey.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.survey.mapper.QfKeyNameMapper;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.service.IQfKeyNameService;

import javax.servlet.http.HttpServletResponse;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@Service
public class QfKeyNameServiceImpl implements IQfKeyNameService 
{
    @Autowired
    private QfKeyNameMapper qfKeyNameMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public QfKeyName selectQfKeyNameById(Long id)
    {
        return qfKeyNameMapper.selectQfKeyNameById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<QfKeyName> selectQfKeyNameList(QfKeyName qfKeyName)
    {
        return qfKeyNameMapper.selectQfKeyNameList(qfKeyName);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQfKeyName(QfKeyName qfKeyName)
    {
        return qfKeyNameMapper.insertQfKeyName(qfKeyName);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param qfKeyName 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQfKeyName(QfKeyName qfKeyName)
    {
        return qfKeyNameMapper.updateQfKeyName(qfKeyName);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteQfKeyNameByIds(Long[] ids)
    {
        return qfKeyNameMapper.deleteQfKeyNameByIds(ids);
    }




}
