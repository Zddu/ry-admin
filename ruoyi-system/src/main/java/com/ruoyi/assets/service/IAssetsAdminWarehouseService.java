package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsAdminWarehouse;

/**
 * 管理员仓库Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public interface IAssetsAdminWarehouseService 
{
    /**
     * 查询管理员仓库
     * 
     * @param id 管理员仓库ID
     * @return 管理员仓库
     */
    public AssetsAdminWarehouse selectAssetsAdminWarehouseById(Long id);

    /**
     * 查询管理员仓库列表
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 管理员仓库集合
     */
    public List<AssetsAdminWarehouse> selectAssetsAdminWarehouseList(AssetsAdminWarehouse assetsAdminWarehouse);

    /**
     * 新增管理员仓库
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 结果
     */
    public int insertAssetsAdminWarehouse(AssetsAdminWarehouse assetsAdminWarehouse);

    /**
     * 修改管理员仓库
     * 
     * @param assetsAdminWarehouse 管理员仓库
     * @return 结果
     */
    public int updateAssetsAdminWarehouse(AssetsAdminWarehouse assetsAdminWarehouse);

    /**
     * 批量删除管理员仓库
     * 
     * @param ids 需要删除的管理员仓库ID
     * @return 结果
     */
    public int deleteAssetsAdminWarehouseByIds(Long[] ids);

    /**
     * 删除管理员仓库信息
     * 
     * @param id 管理员仓库ID
     * @return 结果
     */
    public int deleteAssetsAdminWarehouseById(Long id);
}
