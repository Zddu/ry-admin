package com.ruoyi.web.controller.assets;

import com.ruoyi.assets.domain.*;
import com.ruoyi.assets.service.IAssetsItemsService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
}
