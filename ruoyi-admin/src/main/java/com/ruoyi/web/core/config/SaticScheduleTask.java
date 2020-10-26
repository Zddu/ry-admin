package com.ruoyi.web.core.config;

import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.mapper.RepairRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Autowired
    private RepairRecordMapper repairRecordMapper;

//    或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=120000)
    private void configureTasks() {
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