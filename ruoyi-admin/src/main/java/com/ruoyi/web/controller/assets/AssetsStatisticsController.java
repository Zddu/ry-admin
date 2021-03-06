package com.ruoyi.web.controller.assets;

import com.ruoyi.assets.domain.*;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @date 2020/10/18 -- 9:05
 **/
@RestController
@RequestMapping("/assets/statistics")
public class AssetsStatisticsController extends BaseController {
    @Autowired
    private IAssetsItemsService assetsItemsSchoolService;
    @Autowired
    private TokenService tokenService;
    /**
     * 获取资产分发详细信息
     */
    @GetMapping("/by-school")
    public TableDataInfo AssetsStatisticsBySchool(AssetsStatisticsBySchool assetsStatistics) {
        startPage();
        List<AssetsStatisticsBySchool> list=assetsItemsSchoolService.AssetsStatisticsBySchool();
        return getDataTable(list);
    }
    /**
     * 导出资产统计（以所属单位为标准）
     */
    @Log(title = "导出资产统计（以所属单位为标准）", businessType = BusinessType.EXPORT)
    @GetMapping("/export/by-school")
    public AjaxResult exportByschool() {
        List<AssetsStatisticsBySchool> list = assetsItemsSchoolService.AssetsStatisticsBySchool();
        ExcelUtil<AssetsStatisticsBySchool> util = new ExcelUtil<>(AssetsStatisticsBySchool.class);
        return util.exportExcel(list, "资产统计");
    }


    @GetMapping("/by-type")
    public TableDataInfo AssetsStatisticsByType(AssetsStatisticsByType assetsStatistics) {
        startPage();
        List<AssetsStatisticsByType> list=assetsItemsSchoolService.AssetsStatisticsByType();
        return getDataTable(list);
    }
    /**
     * 导出资产统计（以设备类型为标准）
     */
    @Log(title = "导出资产统计（以设备类型为标准）", businessType = BusinessType.EXPORT)
    @GetMapping("/export/by-type")
    public AjaxResult exportByType() {
        List<AssetsStatisticsByType> list = assetsItemsSchoolService.AssetsStatisticsByType();
        ExcelUtil<AssetsStatisticsByType> util = new ExcelUtil<>(AssetsStatisticsByType.class);
        return util.exportExcel(list, "资产统计");
    }

    @GetMapping("/by-batch")
    public TableDataInfo AssetsStatisticsByBatch(AssetsStatisticsByBatch assetsStatistics) {
        startPage();
        List<AssetsStatisticsByBatch> list=assetsItemsSchoolService.AssetsStatisticsByBatch();

        return getDataTable(list);
    }
    /**
     * 导出资产统计（以批次号为标准）
     */
    @Log(title = "导出资产统计（以批次号为标准）", businessType = BusinessType.EXPORT)
    @GetMapping("/export/by-batch")
    public AjaxResult exportByBatch() {
        List<AssetsStatisticsByBatch> list = assetsItemsSchoolService.AssetsStatisticsByBatch();
        ExcelUtil<AssetsStatisticsByBatch> util = new ExcelUtil<>(AssetsStatisticsByBatch.class);
        return util.exportExcel(list, "资产统计");
    }


    /**
     * 常规统计
     */
    @GetMapping("/list")
    public TableDataInfo AssetsStatistics(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        if (!ObjectUtils.isEmpty(assetsItems) && assetsItems.getItemBelonger() == null)
            assetsItems.setItemBelonger(deptId);
        startPage();
        List<AssetsStatistics> list=assetsItemsSchoolService.getAssetsStatistics(assetsItems);
        return getDataTable(list);
    }
    /**
     * 导出资产统计
     */
    @Log(title = "导出资产统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        if (!ObjectUtils.isEmpty(assetsItems) && assetsItems.getItemBelonger() == null)
            assetsItems.setItemBelonger(deptId);
        List<AssetsStatistics> list = assetsItemsSchoolService.getAssetsStatistics(assetsItems);
        ExcelUtil<AssetsStatistics> util = new ExcelUtil<>(AssetsStatistics.class);
        return util.exportExcel(list, "资产统计");
    }

    /**
     * 三级联动
     */
    @GetMapping("/linkage")
    public AjaxResult threeLevelLinkage(AssetsItems assetsItems) {
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("batchNums",assetsItemsSchoolService.getBatchNumByAssetsItem(assetsItems));
        ajaxResult.put("schools",assetsItemsSchoolService.getSchoolsByAssetsItem(assetsItems));
        ajaxResult.put("types",assetsItemsSchoolService.getTypesByAssetsItem(assetsItems));
        return ajaxResult;
    }
    /**
     * 三级联动
     */
    @GetMapping("/sh_linkage")
    public AjaxResult threeLevelLinkageBySchool(AssetsItems assetsItems) {
        Long deptId = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getDeptId();
        if (!ObjectUtils.isEmpty(assetsItems) && assetsItems.getItemBelonger() == null)
            assetsItems.setItemBelonger(deptId);
        AjaxResult ajaxResult=AjaxResult.success();
        assetsItems.setItemBelonger(deptId);
        ajaxResult.put("batchNums",assetsItemsSchoolService.getBatchNumByAssetsItem(assetsItems));
        ajaxResult.put("types",assetsItemsSchoolService.getTypesByAssetsItem(assetsItems));
        return ajaxResult;
    }
}
