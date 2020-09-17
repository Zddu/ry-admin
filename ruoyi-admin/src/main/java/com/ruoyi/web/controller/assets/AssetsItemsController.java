package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.domain.vo.ItemsSupplierContractVo;
import com.ruoyi.assets.service.IAssetsItemsService;
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
@RequestMapping("/assets/items")
public class AssetsItemsController extends BaseController
{
    @Autowired
    private IAssetsItemsService assetsItemsService;

    /**
     * 展示所有商品列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ItemsSupplierContractVo  itemsSupplierContractVo) {
        startPage();
        List<ItemsSupplierContractVo> list = assetsItemsService.selectItemsSupplierContractVoList(itemsSupplierContractVo);
        return getDataTable(list);
    }
    /**
     * 导出所有商品
     */
    @PreAuthorize("@ss.hasPermi('assets:items:list')")
    @GetMapping("/all")
    public AjaxResult getAll(AssetsItems assetsItems) {
        AjaxResult success = AjaxResult.success();
        success.put("items", assetsItemsService.selectAssetsItemsList(assetsItems));
        return success;
    }

    /**
     * 导出所有列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItems assetsItems)
    {
        List<AssetsItems> list = assetsItemsService.selectAssetsItemsList(assetsItems);
        ExcelUtil<AssetsItems> util = new ExcelUtil<AssetsItems>(AssetsItems.class);
        return util.exportExcel(list, "items");
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsItemsService.selectAssetsItemsById(id));
    }

    /**
     * 新增商品
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsItems assetsItems) {
        return toAjax(assetsItemsService.insertAssetsItems(assetsItems));
    }


    /**
     * 修改商品
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItems assetsItems)
    {
        return toAjax(assetsItemsService.updateAssetsItems(assetsItems));
    }

    /**
     * 删除商品
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(assetsItemsService.deleteAssetsItemsByIds(ids));
    }



}
