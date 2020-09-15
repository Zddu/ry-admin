package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsProperty;
import com.ruoyi.assets.service.IAssetsPropertyService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-14
 */
@RestController
@RequestMapping("/assets/property")
public class AssetsPropertyController extends BaseController
{
    @Autowired
    private IAssetsPropertyService assetsPropertyService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:property:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsProperty assetsProperty)
    {
        startPage();
        List<AssetsProperty> list = assetsPropertyService.selectAssetsPropertyList(assetsProperty);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:property:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsProperty assetsProperty)
    {
        List<AssetsProperty> list = assetsPropertyService.selectAssetsPropertyList(assetsProperty);
        ExcelUtil<AssetsProperty> util = new ExcelUtil<AssetsProperty>(AssetsProperty.class);
        return util.exportExcel(list, "property");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:property:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsPropertyService.selectAssetsPropertyById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:property:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsProperty assetsProperty)
    {
        return toAjax(assetsPropertyService.insertAssetsProperty(assetsProperty));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:property:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsProperty assetsProperty)
    {
        return toAjax(assetsPropertyService.updateAssetsProperty(assetsProperty));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:property:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsPropertyService.deleteAssetsPropertyByIds(ids));
    }
}
