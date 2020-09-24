package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.service.IAssetsItemsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资产管理Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@RestController
@RequestMapping("/assets/items")
public class AssetsItemsController extends BaseController
{
    @Autowired
    private IAssetsItemsService assetsItemsSchoolService;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询资产管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getParentId();
        if (ObjectUtils.isEmpty(assetsItems))
        assetsItems.setItemBelonger(deptId);
        startPage();
        List<AssetsItems> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItems);
        return getDataTable(list);
    }

    /**
     * 导出资产管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:school:export')")
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItems assetsItems) {
        List<AssetsItems> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItems);
        ExcelUtil<AssetsItems> util = new ExcelUtil<AssetsItems>(AssetsItems.class);
        return util.exportExcel(list, "school");
    }

    /**
     * 获取资产管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(assetsItemsSchoolService.selectAssetsItemsSchoolById(id));
    }

    /**
     * 新增资产管理
     */
    @PreAuthorize("@ss.hasPermi('assets:school:add')")
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getParentId();
        assetsItems.setItemBelonger(deptId);
        return toAjax(assetsItemsSchoolService.insertAssetsItemsSchool(assetsItems));
    }

    /**
     * 修改资产管理
     */
    @PreAuthorize("@ss.hasPermi('assets:school:edit')")
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItems assetsItems)
    {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchool(assetsItems));
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
