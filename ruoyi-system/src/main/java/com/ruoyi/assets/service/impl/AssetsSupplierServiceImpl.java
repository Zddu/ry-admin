package com.ruoyi.assets.service.impl;

import com.ruoyi.assets.domain.AssetsSupplier;
import com.ruoyi.assets.mapper.AssetsSupplierMapper;
import com.ruoyi.assets.service.IAssetsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-16
 */
@Service
public class AssetsSupplierServiceImpl implements IAssetsSupplierService
{
    @Autowired
    private AssetsSupplierMapper assetsSupplierMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public AssetsSupplier selectAssetsSupplierById(Long id)
    {
        return assetsSupplierMapper.selectAssetsSupplierById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetsSupplier> selectAssetsSupplierList(AssetsSupplier assetsSupplier)
    {
        return assetsSupplierMapper.selectAssetsSupplierList(assetsSupplier);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetsSupplier(AssetsSupplier assetsSupplier) {
        return assetsSupplierMapper.insertAssetsSupplier(assetsSupplier);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetsSupplier(AssetsSupplier assetsSupplier)
    {
        return assetsSupplierMapper.updateAssetsSupplier(assetsSupplier);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsSupplierByIds(Long[] ids)
    {
        return assetsSupplierMapper.deleteAssetsSupplierByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAssetsSupplierById(Long id)
    {
        return assetsSupplierMapper.deleteAssetsSupplierById(id);
    }
}
