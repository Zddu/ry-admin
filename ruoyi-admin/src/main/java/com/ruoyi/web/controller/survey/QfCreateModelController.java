package com.ruoyi.web.controller.survey;

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
import com.ruoyi.survey.domain.QfCreateModel;
import com.ruoyi.survey.service.IQfCreateModelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发布问卷的模板Controller
 *
 * @author Zddeä¸¶
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/survey/model")
public class QfCreateModelController extends BaseController {
    @Autowired
    private IQfCreateModelService qfCreateModelService;

    /**
     * 查询发布问卷的模板列表
     */

    @GetMapping("/list")
    public TableDataInfo list(QfCreateModel qfCreateModel) {
        startPage();
        List<QfCreateModel> list = qfCreateModelService.selectQfCreateModelList(qfCreateModel);
        return getDataTable(list);
    }

    /**
     * 导出发布问卷的模板列表
     */
    @PreAuthorize("@ss.hasPermi('survey:model:export')")
    @Log(title = "发布问卷的模板", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QfCreateModel qfCreateModel) {
        List<QfCreateModel> list = qfCreateModelService.selectQfCreateModelList(qfCreateModel);
        ExcelUtil<QfCreateModel> util = new ExcelUtil<QfCreateModel>(QfCreateModel.class);
        return util.exportExcel(list, "model");
    }

    /**
     * 获取发布问卷的模板详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(qfCreateModelService.selectQfCreateModelById(id));
    }

    /**
     * 新增发布问卷的模板
     */
    @PreAuthorize("@ss.hasPermi('survey:model:add')")
    @Log(title = "发布问卷的模板", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QfCreateModel qfCreateModel) {
        return toAjax(qfCreateModelService.insertQfCreateModel(qfCreateModel));
    }

    /**
     * 修改发布问卷的模板
     */
    @PreAuthorize("@ss.hasPermi('survey:model:edit')")
    @Log(title = "发布问卷的模板", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfCreateModel qfCreateModel) {
        return toAjax(qfCreateModelService.updateQfCreateModel(qfCreateModel));
    }

    /**
     * 删除发布问卷的模板
     */
    @Log(title = "发布问卷的模板", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(qfCreateModelService.deleteQfCreateModelByIds(ids));
    }
}
