package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsSchoolWarehouse;

/**
 * 学校仓库Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public interface IAssetsSchoolWarehouseService 
{
    /**
     * 查询学校仓库
     * 
     * @param id 学校仓库ID
     * @return 学校仓库
     */
    public AssetsSchoolWarehouse selectAssetsSchoolWarehouseById(Long id);

    /**
     * 查询学校仓库列表
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 学校仓库集合
     */
    public List<AssetsSchoolWarehouse> selectAssetsSchoolWarehouseList(AssetsSchoolWarehouse assetsSchoolWarehouse);

    /**
     * 新增学校仓库
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 结果
     */
    public int insertAssetsSchoolWarehouse(AssetsSchoolWarehouse assetsSchoolWarehouse);

    /**
     * 修改学校仓库
     * 
     * @param assetsSchoolWarehouse 学校仓库
     * @return 结果
     */
    public int updateAssetsSchoolWarehouse(AssetsSchoolWarehouse assetsSchoolWarehouse);

    /**
     * 批量删除学校仓库
     * 
     * @param ids 需要删除的学校仓库ID
     * @return 结果
     */
    public int deleteAssetsSchoolWarehouseByIds(Long[] ids);

    /**
     * 删除学校仓库信息
     * 
     * @param id 学校仓库ID
     * @return 结果
     */
    public int deleteAssetsSchoolWarehouseById(Long id);
}
