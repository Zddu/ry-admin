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
import com.ruoyi.assets.domain.AssetsItemsDistribute;
import com.ruoyi.assets.service.IAssetsItemsDistributeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产分发Controller
 *
 * @author Zddeä¸¶
 * @date 2020-10-16
 */
@RestController
@RequestMapping("/assets/distribute")
public class AssetsItemsDistributeController extends BaseController {
    @Autowired
    private IAssetsItemsDistributeService assetsItemsDistributeService;

    /**
     * 查询资产分发列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AssetsItemsDistribute assetsItemsDistribute) {
        startPage();
        List<AssetsItemsDistribute> list = assetsItemsDistributeService.selectAssetsItemsDistributeList(assetsItemsDistribute);
        return getDataTable(list);
    }

    /**
     * 导出资产分发列表
     */
    @Log(title = "资产分发", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItemsDistribute assetsItemsDistribute) {
        List<AssetsItemsDistribute> list = assetsItemsDistributeService.selectAssetsItemsDistributeList(assetsItemsDistribute);
        ExcelUtil<AssetsItemsDistribute> util = new ExcelUtil<AssetsItemsDistribute>(AssetsItemsDistribute.class);
        return util.exportExcel(list, "distribute");
    }

    /**
     * 获取资产分发详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(assetsItemsDistributeService.selectAssetsItemsDistributeById(id));
    }

    /**
     * 新增资产分发
     */
    @Log(title = "资产分发", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsItemsDistribute assetsItemsDistribute) {
        return toAjax(assetsItemsDistributeService.insertAssetsItemsDistribute(assetsItemsDistribute));
    }

    /**
     * 修改资产分发
     */
    @Log(title = "资产分发", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItemsDistribute assetsItemsDistribute) {
        return toAjax(assetsItemsDistributeService.updateAssetsItemsDistribute(assetsItemsDistribute));
    }

    /**
     * 删除资产分发
     */
    @Log(title = "资产分发", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(assetsItemsDistributeService.deleteAssetsItemsDistributeByIds(ids));
    }
}
