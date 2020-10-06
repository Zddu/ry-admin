package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemsMaintenance;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
public interface IAssetsItemsMaintenanceService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public AssetsItemsMaintenance selectAssetsItemsMaintenanceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetsItemsMaintenance> selectAssetsItemsMaintenanceList(AssetsItemsMaintenance assetsItemsMaintenance);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetsItemsMaintenance(AssetsItemsMaintenance assetsItemsMaintenance);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetsItemsMaintenance 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetsItemsMaintenance(AssetsItemsMaintenance assetsItemsMaintenance);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsItemsMaintenanceByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsItemsMaintenanceById(Long id);
}
