package com.ruoyi.repair.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.repair.mapper.RepairRecordMapper;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.service.IRepairRecordService;

/**
 * 保修记录Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
@Service
public class RepairRecordServiceImpl implements IRepairRecordService {
    @Autowired
    private RepairRecordMapper repairRecordMapper;

    /**
     * 查询保修记录
     * 
     * @param id 保修记录ID
     * @return 保修记录
     */
    @Override
    public RepairRecord selectRepairRecordById(Long id)
    {
        return repairRecordMapper.selectRepairRecordById(id);
    }

    /**
     * 查询保修记录列表
     * 
     * @param repairRecord 保修记录
     * @return 保修记录
     */
    @Override
    public List<RepairRecord> selectRepairRecordList(RepairRecord repairRecord)
    {
        return repairRecordMapper.selectRepairRecordList(repairRecord);
    }

    /**
     * 新增保修记录
     * 
     * @param repairRecord 保修记录
     * @return 结果
     */
    @Override
    public int insertRepairRecord(RepairRecord repairRecord)
    {
        repairRecord.setCreateTime(DateUtils.getNowDate());
        return repairRecordMapper.insertRepairRecord(repairRecord);
    }

    /**
     * 修改保修记录
     * 
     * @param repairRecord 保修记录
     * @return 结果
     */
    @Override
    public int updateRepairRecord(RepairRecord repairRecord)
    {
        return repairRecordMapper.updateRepairRecord(repairRecord);
    }

    /**
     * 批量删除保修记录
     * 
     * @param ids 需要删除的保修记录ID
     * @return 结果
     */
    @Override
    public int deleteRepairRecordByIds(Long[] ids)
    {
        return repairRecordMapper.deleteRepairRecordByIds(ids);
    }

    /**
     * 删除保修记录信息
     * 
     * @param id 保修记录ID
     * @return 结果
     */
    @Override
    public int deleteRepairRecordById(Long id)
    {
        return repairRecordMapper.deleteRepairRecordById(id);
    }

    @Override
    public List<RepairRecord> selectRepairRecordListByLimit(Integer num) {
        return repairRecordMapper.selectRepairRecordListByLimit(num);
    }

    @Override
    public List<RepairRecord> selectRepairRecordListByCondition(String str) {
        return repairRecordMapper.selectRepairRecordListByCondition(str);
    }
}
