package com.ruoyi.web.controller.repair;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.service.TokenService;

import com.ruoyi.repair.domain.RepairMaintenance;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.service.IRepairMaintenanceService;
import com.ruoyi.repair.service.IRepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/3 -- 14:21
 **/
@RestController("/weixin/msg")
public class WeixinController extends BaseController {

    @Autowired
    private IRepairRecordService repairRecordService;

    /**
     * 查询报修记录列表
     */
    @PostMapping("/all")
    public List<RepairRecord> all() {
        return repairRecordService.selectRepairRecordListTop10();
    }
    /**
     * 根据微信号查询报修记录
     */
    @GetMapping("/list")
    public List<RepairRecord> list(RepairRecord repairRecord) {
        if (repairRecord==null&&repairRecord.getWeixinNum()==null){
            return new ArrayList<RepairRecord>();
        }
        return repairRecordService.selectRepairRecordList(repairRecord);
    }
    /**
     * 新增报修记录
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody RepairRecord repairRecord) {
        System.out.println(repairRecord);
        return toAjax(repairRecordService.insertRepairRecord(repairRecord));
    }

}
