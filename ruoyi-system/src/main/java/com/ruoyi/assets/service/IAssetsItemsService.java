package com.ruoyi.assets.service;


import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.domain.vo.ItemsSupplierContractVo;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
public interface IAssetsItemsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsItems selectAssetsItemsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsItems> selectAssetsItemsList(AssetsItems assetsItems);
    List<ItemsSupplierContractVo> selectItemsSupplierContractVoList(ItemsSupplierContractVo itemsSupplierContractVo);
    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsItems(AssetsItems assetsItems);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsItems 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsItems(AssetsItems assetsItems);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsItemsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsItemsById(Long id);


}
