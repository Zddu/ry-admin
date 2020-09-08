package com.ruoyi.web.controller.survey;

import java.util.HashMap;
import java.util.List;

import com.ruoyi.survey.service.IQfCreateFormService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.service.IQfUserFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@RestController
@RequestMapping("/survey/form")
public class QfUserFormController extends BaseController
{
    @Autowired
    private IQfUserFormService qfUserFormService;

    @Autowired
    private IQfCreateFormService qfCreateFormService;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(QfUserForm qfUserForm)
    {
        startPage();
        List<QfUserForm> list = qfUserFormService.selectQfUserFormList(qfUserForm);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:form:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QfUserForm qfUserForm)
    {
        List<QfUserForm> list = qfUserFormService.selectQfUserFormList(qfUserForm);
        ExcelUtil<QfUserForm> util = new ExcelUtil<QfUserForm>(QfUserForm.class);
        return util.exportExcel(list, "form");
    }



    /**
     * 上传答案
     */
    @PreAuthorize("@ss.hasPermi('survey:form:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestParam String json,Long sid,Long cid) {
        return toAjax(qfUserFormService.insertAnswer(json,sid,cid));
    }



    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:form:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfUserForm qfUserForm)
    {
        return toAjax(qfUserFormService.updateQfUserForm(qfUserForm));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:form:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qfUserFormService.deleteQfUserFormByIds(ids));
    }




}
