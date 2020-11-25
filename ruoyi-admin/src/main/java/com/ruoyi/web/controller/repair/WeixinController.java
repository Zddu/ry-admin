package com.ruoyi.web.controller.repair;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.service.IRepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/3 -- 14:21
 **/
@RestController
@RequestMapping("/wx/msg")
public class WeixinController extends BaseController {

    @Autowired
    private IRepairRecordService repairRecordService;

    /**
     * 查询报修记录列表
     */
    @GetMapping("/all")
    public  List<RepairRecord> all(@RequestParam String num) {
        Integer limit=null;
        if (!ObjectUtils.isEmpty(num)){
            limit=Integer.parseInt(num);
        }
        List<RepairRecord> repairRecords = repairRecordService.selectRepairRecordListByLimit(limit);
        return repairRecords;
    }

    /**
     * 条件查询
     * @param str
     * @return
     */
    @PostMapping("/condition")
    public  List<RepairRecord> condition(@RequestParam String str) {
        List<RepairRecord> repairRecords = repairRecordService.selectRepairRecordListByCondition(str);
        return repairRecords;
    }
    /**
     * 查看详情
     */
    @GetMapping("/detail")
    public  List<RepairRecord> detail(String orderNum) {
        RepairRecord repairRecord = new RepairRecord();
        repairRecord.setOrderNum(orderNum);
        return repairRecordService.selectRepairRecordList(repairRecord);
    }

    /**
     * 根据微信号查询报修记录
     */
    @RequestMapping("/list")
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
        repairRecord.setOrderNum(IdUtils.getOrderIdByUUId());
        return toAjax(repairRecordService.insertRepairRecord(repairRecord));
    }

}
