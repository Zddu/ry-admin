package com.ruoyi.assets.mapper;

import java.util.List;

import com.ruoyi.assets.domain.*;

/**
 * 资产管理Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public interface AssetsItemsMapper
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

    List<String> getBatchNum();

    int deleteAssetsItemsSchoolByAssetsItem(AssetsItems assetsItems);

    int deleteAssetsItemsByDistributeByIds(Long[] ids);

    int deleteAssetsItemsSchoolByItemsDistributeId(Long id);

    List<AssetsStatisticsBySchool> selectAssetsStatisticsBySchool();

    List<AssetsItems> selectAssetsItemsSchoolByDeptId(Long id);

    List<AssetsStatisticsByType> selectAssetsStatisticsByType();
    List<AssetsItems> selectAssetsItemsSchoolByType(Long id);

    List<AssetsStatisticsByBatch> selectAssetsStatisticsByBatch();
    List<AssetsItems> selectAssetsItemsSchoolByBatch(Long id);

    List<AssetsStatistics> getAssetsStatistics(AssetsItems assetsItems);

    List<String> getSchoolsByAssetsItem(AssetsItems assetsItems);

    List<String> getBatchNumByAssetsItem(AssetsItems assetsItems);

    List<String> getTypesByAssetsItem(AssetsItems assetsItems);
}
