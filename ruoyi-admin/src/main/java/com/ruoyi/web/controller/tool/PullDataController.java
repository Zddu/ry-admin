package com.ruoyi.web.controller.tool;

import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.mapper.RepairRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date 2020/11/21 -- 13:26
 **/
@RestController
@RequestMapping("/main/pull")
public class PullDataController {
    @Autowired
    private RepairRecordMapper repairRecordMapper;
    @GetMapping("/data")
    public void pullData(){
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE.name());
        List<RepairRecord> repairRecords = repairRecordMapper.selectRepairRecordList(new RepairRecord());
        DynamicDataSourceContextHolder.clearDataSourceType();
        DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.MASTER.name());
        List<RepairRecord> repairRecordMain = repairRecordMapper.selectRepairRecordList(new RepairRecord());
        for (RepairRecord repairRecord : repairRecords) {
            if (!repairRecordMain.contains(repairRecord)){
                repairRecordMapper.insertRepairRecord(repairRecord);
            }
        }
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
