package com.ruoyi.web.controller.assets;


import com.ruoyi.assets.domain.AssetsPropertiesModel;
import com.ruoyi.assets.service.IAssetsPropertiesModelService;
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
@RequestMapping("/assets/model")
public class AssetsPropertiesModelController extends BaseController
{
    @Autowired
    private IAssetsPropertiesModelService assetsPropertiesModelService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('assets:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsPropertiesModel assetsPropertiesModel) {
        startPage();
        List<AssetsPropertiesModel> list = assetsPropertiesModelService.selectAssetsPropertiesModelList(assetsPropertiesModel);
        return getDataTable(list);
    }




    /**
     * 获取模板信息
     */
    @PreAuthorize("@ss.hasPermi('assets:model:query')")
    @GetMapping(value = "/model")
    public AjaxResult getInfo() {
        return AjaxResult.success(assetsPropertiesModelService.selectAssetsPropertiesModel());
    }

    /**
     * 修改模板字段(已存在保留，不存在插入)
     */
    @PreAuthorize("@ss.hasPermi('assets:model:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/modify")
    public AjaxResult modify(@RequestBody List<AssetsPropertiesModel> assetsPropertiesModels) {
        return toAjax(assetsPropertiesModelService.modifyPropertiesModel(assetsPropertiesModels));
    }


    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('assets:model:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsPropertiesModel assetsPropertiesModel) {
        return toAjax(assetsPropertiesModelService.insertAssetsPropertiesModel(assetsPropertiesModel));
    }





}
