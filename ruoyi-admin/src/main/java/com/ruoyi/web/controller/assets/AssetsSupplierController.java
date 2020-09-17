package com.ruoyi.web.controller.assets;

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
import com.ruoyi.assets.domain.AssetsSupplier;
import com.ruoyi.assets.service.IAssetsSupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/assets/supplier")
public class AssetsSupplierController extends BaseController {
    @Autowired
    private IAssetsSupplierService assetsSupplierService;

    /**
     * 查询分页供应商列表
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsSupplier assetsSupplier) {
        startPage();
        List<AssetsSupplier> list = assetsSupplierService.selectAssetsSupplierList(assetsSupplier);
        return getDataTable(list);
    }
    /**
     * 查询所有供应商列表
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:list')")
    @GetMapping("/all")
    public AjaxResult all(AssetsSupplier assetsSupplier) {
        AjaxResult success = AjaxResult.success();
        success.put("suppliers",assetsSupplierService.selectAssetsSupplierList(assetsSupplier));
        return success;
    }
    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsSupplier assetsSupplier) {
        List<AssetsSupplier> list = assetsSupplierService.selectAssetsSupplierList(assetsSupplier);
        ExcelUtil<AssetsSupplier> util = new ExcelUtil<AssetsSupplier>(AssetsSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsSupplierService.selectAssetsSupplierById(id));
    }

    /**
     * 新增或者修改供应商
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsSupplier assetsSupplier) {
        return toAjax(assetsSupplierService.insertAssetsSupplier(assetsSupplier));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsSupplier assetsSupplier)
    {
        return toAjax(assetsSupplierService.updateAssetsSupplier(assetsSupplier));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:supplier:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(assetsSupplierService.deleteAssetsSupplierByIds(ids));
    }
}
