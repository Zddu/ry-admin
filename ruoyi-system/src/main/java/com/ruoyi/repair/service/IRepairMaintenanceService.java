package com.ruoyi.repair.service;

import java.util.List;
import com.ruoyi.repair.domain.RepairMaintenance;

/**
 * 维修记录Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
public interface IRepairMaintenanceService 
{
    /**
     * 查询维修记录
     * 
     * @param id 维修记录ID
     * @return 维修记录
     */
    public RepairMaintenance selectRepairMaintenanceById(Long id);

    /**
     * 查询维修记录列表
     * 
     * @param repairMaintenance 维修记录
     * @return 维修记录集合
     */
    public List<RepairMaintenance> selectRepairMaintenanceList(RepairMaintenance repairMaintenance);

    /**
     * 新增维修记录
     * 
     * @param repairMaintenance 维修记录
     * @return 结果
     */
    public int insertRepairMaintenance(RepairMaintenance repairMaintenance);

    /**
     * 修改维修记录
     * 
     * @param repairMaintenance 维修记录
     * @return 结果
     */
    public int updateRepairMaintenance(RepairMaintenance repairMaintenance);

    /**
     * 批量删除维修记录
     * 
     * @param ids 需要删除的维修记录ID
     * @return 结果
     */
    public int deleteRepairMaintenanceByIds(Long[] ids);

    /**
     * 删除维修记录信息
     * 
     * @param id 维修记录ID
     * @return 结果
     */
    public int deleteRepairMaintenanceById(Long id);
}
