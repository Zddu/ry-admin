package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsItemsSchool;
import com.ruoyi.assets.service.IAssetsItemsSchoolService;
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
 * 资产管理Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@RestController
@RequestMapping("/assets/school")
public class AssetsItemsSchoolController extends BaseController
{
    @Autowired
    private IAssetsItemsSchoolService assetsItemsSchoolService;

    /**
     * 查询资产管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsItemsSchool assetsItemsSchool)
    {
        startPage();
        List<AssetsItemsSchool> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItemsSchool);
        return getDataTable(list);
    }

    /**
     * 导出资产管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:school:export')")
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItemsSchool assetsItemsSchool)
    {
        List<AssetsItemsSchool> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItemsSchool);
        ExcelUtil<AssetsItemsSchool> util = new ExcelUtil<AssetsItemsSchool>(AssetsItemsSchool.class);
        return util.exportExcel(list, "school");
    }

    /**
     * 获取资产管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsItemsSchoolService.selectAssetsItemsSchoolById(id));
    }

    /**
     * 新增资产管理
     */
    @PreAuthorize("@ss.hasPermi('assets:school:add')")
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsItemsSchool assetsItemsSchool)
    {
        return toAjax(assetsItemsSchoolService.insertAssetsItemsSchool(assetsItemsSchool));
    }

    /**
     * 修改资产管理
     */
    @PreAuthorize("@ss.hasPermi('assets:school:edit')")
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItemsSchool assetsItemsSchool)
    {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchool(assetsItemsSchool));
    }

    /**
     * 删除资产管理
     */
    @PreAuthorize("@ss.hasPermi('assets:school:remove')")
    @Log(title = "资产管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsItemsSchoolService.deleteAssetsItemsSchoolByIds(ids));
    }
}
