package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemsSchool;

/**
 * 资产管理Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public interface AssetsItemsSchoolMapper 
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理ID
     * @return 资产管理
     */
    public AssetsItemsSchool selectAssetsItemsSchoolById(Long id);

    /**
     * 查询资产管理列表
     * 
     * @param assetsItemsSchool 资产管理
     * @return 资产管理集合
     */
    public List<AssetsItemsSchool> selectAssetsItemsSchoolList(AssetsItemsSchool assetsItemsSchool);

    /**
     * 新增资产管理
     * 
     * @param assetsItemsSchool 资产管理
     * @return 结果
     */
    public int insertAssetsItemsSchool(AssetsItemsSchool assetsItemsSchool);

    /**
     * 修改资产管理
     * 
     * @param assetsItemsSchool 资产管理
     * @return 结果
     */
    public int updateAssetsItemsSchool(AssetsItemsSchool assetsItemsSchool);

    /**
     * 删除资产管理
     * 
     * @param id 资产管理ID
     * @return 结果
     */
    public int deleteAssetsItemsSchoolById(Long id);

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsItemsSchoolByIds(Long[] ids);
}
