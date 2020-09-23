package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItems;

/**
 * 资产管理Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public interface IAssetsItemsService
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    public AssetsItems selectAssetsItemsSchoolById(Long id);

    /**
     * 查询资产管理列表
     * 
     * @param assetsItems 资产管理
     * @return 资产管理集合
     */
    public List<AssetsItems> selectAssetsItemsSchoolList(AssetsItems assetsItems);

    /**
     * 新增资产管理
     * 
     * @param assetsItems 资产管理
     * @return 结果
     */
    public int insertAssetsItemsSchool(AssetsItems assetsItems);

    /**
     * 修改资产管理
     * 
     * @param assetsItems 资产管理
     * @return 结果
     */
    public int updateAssetsItemsSchool(AssetsItems assetsItems);

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的资产管理ID
     * @return 结果
     */
    public int deleteAssetsItemsSchoolByIds(Long[] ids);

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理ID
     * @return 结果
     */
    public int deleteAssetsItemsSchoolById(Long id);
}
