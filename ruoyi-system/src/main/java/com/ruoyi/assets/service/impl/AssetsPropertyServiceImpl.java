package com.ruoyi.assets.service.impl;


import com.ruoyi.assets.domain.AssetsProperty;
import com.ruoyi.assets.mapper.AssetsPropertyMapper;
import com.ruoyi.assets.service.IAssetsPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
@Service
public class AssetsPropertyServiceImpl implements IAssetsPropertyService
{
    @Autowired
    private AssetsPropertyMapper assetsPropertyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsProperty selectAssetsPropertyById(Long id)
    {
        return assetsPropertyMapper.selectAssetsPropertyById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsProperty> selectAssetsPropertyList(AssetsProperty assetsProperty)
    {
        return assetsPropertyMapper.selectAssetsPropertyList(assetsProperty);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetsProperty(AssetsProperty assetsProperty)
    {
        return assetsPropertyMapper.insertAssetsProperty(assetsProperty);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsProperty 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsProperty(AssetsProperty assetsProperty)
    {
        return assetsPropertyMapper.updateAssetsProperty(assetsProperty);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsPropertyByIds(Long[] ids)
    {
        return assetsPropertyMapper.deleteAssetsPropertyByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsPropertyById(Long id)
    {
        return assetsPropertyMapper.deleteAssetsPropertyById(id);
    }
}
