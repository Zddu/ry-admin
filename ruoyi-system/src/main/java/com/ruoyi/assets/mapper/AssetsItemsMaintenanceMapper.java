package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsItemsMaintenance;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
public interface AssetsItemsMaintenanceMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAssetsItemsMaintenanceById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsItemsMaintenanceByIds(Long[] ids);

    List<AssetsItemsMaintenance> selectAssetsItemsMaintenanceByItemId(@Param("id") Long id);
}
