package com.ruoyi.web.controller.repair;

import java.util.List;

import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.framework.datasource.DynamicDataSourceContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.repair.domain.RepairRecord;
import com.ruoyi.repair.service.IRepairRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保修记录Controller
 *
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
@RestController
@RequestMapping("/repair/record")
public class RepairRecordController extends BaseController {
    @Autowired
    private IRepairRecordService repairRecordService;

    /**
     * 查询保修记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RepairRecord repairRecord) {
        startPage();
        List<RepairRecord> list = repairRecordService.selectRepairRecordList(repairRecord);
        return getDataTable(list);
    }

    /**
     * 导出保修记录列表
     */
    @Log(title = "保修记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RepairRecord repairRecord) {
        List<RepairRecord> list = repairRecordService.selectRepairRecordList(repairRecord);
        ExcelUtil<RepairRecord> util = new ExcelUtil<RepairRecord>(RepairRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 获取保修记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(repairRecordService.selectRepairRecordById(id));
    }

    /**
     * 新增保修记录
     */
    @PreAuthorize("@ss.hasPermi('repair:record:add')")
    @Log(title = "保修记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairRecord repairRecord) {
        return toAjax(repairRecordService.insertRepairRecord(repairRecord));
    }


    /**
     * 修改保修记录
     */
    @Log(title = "保修记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepairRecord repairRecord) {
        return toAjax(repairRecordService.updateRepairRecord(repairRecord));
    }

    /**
     * 删除保修记录
     */
    @Log(title = "保修记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        int i = repairRecordService.deleteRepairRecordByIds(ids);

        return toAjax(i);
    }
}
