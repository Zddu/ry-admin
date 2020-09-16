package com.ruoyi.assets.service.impl;


import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.domain.AssetsSupplier;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.mapper.AssetsSupplierMapper;
import com.ruoyi.assets.service.IAssetsItemsService;
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
public class AssetsItemsServiceImpl implements IAssetsItemsService
{
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;
    @Autowired
    private AssetsSupplierMapper assetsSupplierMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsItems selectAssetsItemsById(Long id)
    {
        return assetsItemsMapper.selectAssetsItemsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsItems> selectAssetsItemsList(AssetsItems assetsItems)
    {
        return assetsItemsMapper.selectAssetsItemsList(assetsItems);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetsItems(AssetsItems assetsItems) {
        AssetsSupplier assetsSupplier = assetsSupplierMapper.selectAssetsSupplierById((long) assetsItems.getSupplierId());
        assetsItems.setSupplierName(assetsSupplier.getSupplierName());
        return assetsItemsMapper.insertAssetsItems(assetsItems);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsItems(AssetsItems assetsItems)
    {
        return assetsItemsMapper.updateAssetsItems(assetsItems);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsByIds(Long[] ids)
    {
        return assetsItemsMapper.deleteAssetsItemsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsById(Long id)
    {
        return assetsItemsMapper.deleteAssetsItemsById(id);
    }
}
