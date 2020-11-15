package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.domain.AssetsItemsMaintenance;
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

import javax.validation.Valid;
import java.util.List;

/**
 * 资产管理Controller
 *
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@RestController
@RequestMapping("/assets/items")
public class AssetsItemsController extends BaseController {
    @Autowired
    private IAssetsItemsService assetsItemsSchoolService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询资产管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        if (!ObjectUtils.isEmpty(assetsItems) && assetsItems.getItemBelonger() == null)
            assetsItems.setItemBelonger(deptId);
        startPage();
        List<AssetsItems> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItems);
        return getDataTable(list);
    }
    /**
     * 审核核销商品
     */
    @GetMapping("/write-off")
    public TableDataInfo listWriteOff(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        if (!ObjectUtils.isEmpty(assetsItems) && assetsItems.getItemBelonger() == null)
            assetsItems.setItemBelonger(deptId);
        startPage();
        List<AssetsItems> list = assetsItemsSchoolService.selectAssetsItemsSchoolListNeed2Review(assetsItems);
        return getDataTable(list);
    }
    /**
     * 导出资产管理列表
     */
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        assetsItems.setItemBelonger(deptId);
        List<AssetsItems> list = assetsItemsSchoolService.selectAssetsItemsSchoolList(assetsItems);
        ExcelUtil<AssetsItems> util = new ExcelUtil<AssetsItems>(AssetsItems.class);
        return util.exportExcel(list, "school");
    }
    /**
     * 导出资产管理列表
     */
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export/maintenance-records")
    public AjaxResult exportMaintenanceRecords(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        assetsItems.setItemBelonger(deptId);
        List<AssetsItemsMaintenance> list = assetsItemsSchoolService.selectAssetsAssetsItemsMaintenanceList(assetsItems);
        ExcelUtil<AssetsItemsMaintenance> util = new ExcelUtil<>(AssetsItemsMaintenance.class);
        return util.exportExcel(list, "维修记录");
    }
    /**
     * 获取资产管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(assetsItemsSchoolService.selectAssetsItemsSchoolById(id));
    }

    /**
     * 新增资产管理
     */
//    @PreAuthorize("@ss.hasPermi('assets:school:add')")
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Valid AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        assetsItems.setItemBelonger(deptId);
        assetsItems.setIsModify(0);
        return toAjax(assetsItemsSchoolService.insertAssetsItemsSchool(assetsItems));
    }

    /**
     * 新增维修记录
     */
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping("/add-maintenance")
    public AjaxResult addMaintenance(@RequestBody AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        assetsItems.setItemBelonger(deptId);
        assetsItems.setIsModify(0);
        return toAjax(assetsItemsSchoolService.insertAssetsItemsSchool(assetsItems));
    }

    /**
     * 修改资产管理
     */
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItems assetsItems) {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchool(assetsItems));
    }
    /**
     * 审核核销
     */
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{ids}")
    public AjaxResult edit(@PathVariable Long[] ids) {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchoolByIds(ids));
    }
    /**
     * 批量核销
     */
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @GetMapping("/write-off/{ids}")
    public AjaxResult writeEdit(@PathVariable Long[] ids) {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchoolWriteOffByIds(ids));
    }
    /**
     * 退回核销申请
     */
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PostMapping("/back")
    public AjaxResult returnWriteOff(@RequestBody List<AssetsItems> assetsItems) {
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchoolByAssetsItems(assetsItems));
    }

    /**
     *还原为未核销状态
     */
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PutMapping("/{id}")
    public AjaxResult reduction(@PathVariable Long id) {
        AssetsItems assetsItems = new AssetsItems();
        assetsItems.setId(id);
        assetsItems.setIsWriteOff(0);
        return toAjax(assetsItemsSchoolService.updateAssetsItemsSchool(assetsItems));
    }

    /**
     * 删除资产管理
     */
    @Log(title = "资产管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(assetsItemsSchoolService.deleteAssetsItemsSchoolByIds(ids));
    }



}
