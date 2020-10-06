package com.ruoyi.repair.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.repair.mapper.RepairMaintenanceMapper;
import com.ruoyi.repair.domain.RepairMaintenance;
import com.ruoyi.repair.service.IRepairMaintenanceService;

/**
 * 维修记录Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
@Service
public class RepairMaintenanceServiceImpl implements IRepairMaintenanceService 
{
    @Autowired
    private RepairMaintenanceMapper repairMaintenanceMapper;

    /**
     * 查询维修记录
     * 
     * @param id 维修记录ID
     * @return 维修记录
     */
    @Override
    public RepairMaintenance selectRepairMaintenanceById(Long id)
    {
        return repairMaintenanceMapper.selectRepairMaintenanceById(id);
    }

    /**
     * 查询维修记录列表
     * 
     * @param repairMaintenance 维修记录
     * @return 维修记录
     */
    @Override
    public List<RepairMaintenance> selectRepairMaintenanceList(RepairMaintenance repairMaintenance)
    {
        return repairMaintenanceMapper.selectRepairMaintenanceList(repairMaintenance);
    }

    /**
     * 新增维修记录
     * 
     * @param repairMaintenance 维修记录
     * @return 结果
     */
    @Override
    public int insertRepairMaintenance(RepairMaintenance repairMaintenance)
    {
        repairMaintenance.setCreateTime(DateUtils.getNowDate());
        return repairMaintenanceMapper.insertRepairMaintenance(repairMaintenance);
    }

    /**
     * 修改维修记录
     * 
     * @param repairMaintenance 维修记录
     * @return 结果
     */
    @Override
    public int updateRepairMaintenance(RepairMaintenance repairMaintenance)
    {
        return repairMaintenanceMapper.updateRepairMaintenance(repairMaintenance);
    }

    /**
     * 批量删除维修记录
     * 
     * @param ids 需要删除的维修记录ID
     * @return 结果
     */
    @Override
    public int deleteRepairMaintenanceByIds(Long[] ids)
    {
        return repairMaintenanceMapper.deleteRepairMaintenanceByIds(ids);
    }

    /**
     * 删除维修记录信息
     * 
     * @param id 维修记录ID
     * @return 结果
     */
    @Override
    public int deleteRepairMaintenanceById(Long id)
    {
        return repairMaintenanceMapper.deleteRepairMaintenanceById(id);
    }
}
