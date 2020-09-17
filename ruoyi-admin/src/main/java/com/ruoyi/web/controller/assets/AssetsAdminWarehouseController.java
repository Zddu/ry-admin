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
import com.ruoyi.assets.domain.AssetsAdminWarehouse;
import com.ruoyi.assets.service.IAssetsAdminWarehouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 管理员仓库Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@RestController
@RequestMapping("/assets/warehouse")
public class AssetsAdminWarehouseController extends BaseController
{
    @Autowired
    private IAssetsAdminWarehouseService assetsAdminWarehouseService;

    /**
     * 查询管理员仓库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsAdminWarehouse assetsAdminWarehouse)
    {
        startPage();
        List<AssetsAdminWarehouse> list = assetsAdminWarehouseService.selectAssetsAdminWarehouseList(assetsAdminWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出管理员仓库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:export')")
    @Log(title = "管理员仓库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsAdminWarehouse assetsAdminWarehouse)
    {
        List<AssetsAdminWarehouse> list = assetsAdminWarehouseService.selectAssetsAdminWarehouseList(assetsAdminWarehouse);
        ExcelUtil<AssetsAdminWarehouse> util = new ExcelUtil<AssetsAdminWarehouse>(AssetsAdminWarehouse.class);
        return util.exportExcel(list, "warehouse");
    }

    /**
     * 获取管理员仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsAdminWarehouseService.selectAssetsAdminWarehouseById(id));
    }

    /**
     * 新增管理员仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:add')")
    @Log(title = "管理员仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsAdminWarehouse assetsAdminWarehouse) {
        return toAjax(assetsAdminWarehouseService.insertAssetsAdminWarehouse(assetsAdminWarehouse));
    }

    /**
     * 修改管理员仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:edit')")
    @Log(title = "管理员仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsAdminWarehouse assetsAdminWarehouse)
    {
        return toAjax(assetsAdminWarehouseService.updateAssetsAdminWarehouse(assetsAdminWarehouse));
    }

    /**
     * 删除管理员仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:remove')")
    @Log(title = "管理员仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsAdminWarehouseService.deleteAssetsAdminWarehouseByIds(ids));
    }
}
