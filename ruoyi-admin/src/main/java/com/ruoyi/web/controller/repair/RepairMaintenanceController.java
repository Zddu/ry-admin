package com.ruoyi.web.controller.repair;

import java.util.List;
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
import com.ruoyi.repair.domain.RepairMaintenance;
import com.ruoyi.repair.service.IRepairMaintenanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修记录Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-10-05
 */
@RestController
@RequestMapping("/repair/maintenance")
public class RepairMaintenanceController extends BaseController
{
    @Autowired
    private IRepairMaintenanceService repairMaintenanceService;

    /**
     * 查询维修记录列表
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:list')")
    @GetMapping("/list")
    public TableDataInfo list(RepairMaintenance repairMaintenance)
    {
        startPage();
        List<RepairMaintenance> list = repairMaintenanceService.selectRepairMaintenanceList(repairMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出维修记录列表
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:export')")
    @Log(title = "维修记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RepairMaintenance repairMaintenance)
    {
        List<RepairMaintenance> list = repairMaintenanceService.selectRepairMaintenanceList(repairMaintenance);
        ExcelUtil<RepairMaintenance> util = new ExcelUtil<RepairMaintenance>(RepairMaintenance.class);
        return util.exportExcel(list, "maintenance");
    }

    /**
     * 获取维修记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(repairMaintenanceService.selectRepairMaintenanceById(id));
    }

    /**
     * 新增维修记录
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:add')")
    @Log(title = "维修记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RepairMaintenance repairMaintenance)
    {
        return toAjax(repairMaintenanceService.insertRepairMaintenance(repairMaintenance));
    }

    /**
     * 修改维修记录
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:edit')")
    @Log(title = "维修记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RepairMaintenance repairMaintenance)
    {
        return toAjax(repairMaintenanceService.updateRepairMaintenance(repairMaintenance));
    }

    /**
     * 删除维修记录
     */
    @PreAuthorize("@ss.hasPermi('repair:maintenance:remove')")
    @Log(title = "维修记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(repairMaintenanceService.deleteRepairMaintenanceByIds(ids));
    }
}
