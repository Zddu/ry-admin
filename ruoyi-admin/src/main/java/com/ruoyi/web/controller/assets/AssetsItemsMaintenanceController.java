package com.ruoyi.web.controller.assets;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.assets.domain.AssetsItemsMaintenance;
import com.ruoyi.assets.service.IAssetsItemsMaintenanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.validation.Valid;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
@RestController
@RequestMapping("/assets/maintenance")
public class AssetsItemsMaintenanceController extends BaseController
{
    @Autowired
    private IAssetsItemsMaintenanceService assetsItemsMaintenanceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:maintenance:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsItemsMaintenance assetsItemsMaintenance)
    {
        startPage();
        List<AssetsItemsMaintenance> list = assetsItemsMaintenanceService.selectAssetsItemsMaintenanceList(assetsItemsMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:maintenance:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItemsMaintenance assetsItemsMaintenance)
    {
        List<AssetsItemsMaintenance> list = assetsItemsMaintenanceService.selectAssetsItemsMaintenanceList(assetsItemsMaintenance);
        ExcelUtil<AssetsItemsMaintenance> util = new ExcelUtil<AssetsItemsMaintenance>(AssetsItemsMaintenance.class);
        return util.exportExcel(list, "maintenance");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:maintenance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsItemsMaintenanceService.selectAssetsItemsMaintenanceById(id));
    }

    /**
     * 新增【请填写功能名称】
     */

    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Valid AssetsItemsMaintenance assetsItemsMaintenance) {
        assetsItemsMaintenance.setSubmitTime(DateUtils.getNowDate());
        return toAjax(assetsItemsMaintenanceService.insertAssetsItemsMaintenance(assetsItemsMaintenance));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:maintenance:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItemsMaintenance assetsItemsMaintenance)
    {
        return toAjax(assetsItemsMaintenanceService.updateAssetsItemsMaintenance(assetsItemsMaintenance));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:maintenance:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsItemsMaintenanceService.deleteAssetsItemsMaintenanceByIds(ids));
    }
}
