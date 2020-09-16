package com.ruoyi.assets.mapper;


import com.ruoyi.assets.domain.AssetsSupplier;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-16
 */
public interface AssetsSupplierMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsSupplier selectAssetsSupplierById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsSupplier> selectAssetsSupplierList(AssetsSupplier assetsSupplier);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsSupplier(AssetsSupplier assetsSupplier);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsSupplier 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsSupplier(AssetsSupplier assetsSupplier);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsSupplierById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsSupplierByIds(Long[] ids);
}
