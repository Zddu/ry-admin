package com.ruoyi.repair.mapper;

import java.util.List;
import com.ruoyi.repair.domain.RepairRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 保修记录Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
public interface RepairRecordMapper 
{
    /**
     * 查询保修记录
     * 
     * @param id 保修记录ID
     * @return 保修记录
     */
    public RepairRecord selectRepairRecordById(Long id);

    /**
     * 查询保修记录列表
     * 
     * @param repairRecord 保修记录
     * @return 保修记录集合
     */
    public List<RepairRecord> selectRepairRecordList(RepairRecord repairRecord);

    /**
     * 新增保修记录
     * 
     * @param repairRecord 保修记录
     * @return 结果
     */
    public int insertRepairRecord(RepairRecord repairRecord);

    /**
     * 修改保修记录
     * 
     * @param repairRecord 保修记录
     * @return 结果
     */
    public int updateRepairRecord(RepairRecord repairRecord);

    /**
     * 删除保修记录
     * 
     * @param id 保修记录ID
     * @return 结果
     */
    public int deleteRepairRecordById(Long id);

    /**
     * 批量删除保修记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepairRecordByIds(Long[] ids);

    List<RepairRecord> selectRepairRecordListByLimit(@Param("num") Integer num);

    List<RepairRecord> selectRepairRecordListByCondition(@Param("str") String str);
}
