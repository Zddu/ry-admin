package com.ruoyi.web.controller.survey;

import java.text.ParseException;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.service.IQfCreateFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@RestController
@RequestMapping("/survey/create")
public class QfCreateFormController extends BaseController
{
    @Autowired
    private IQfCreateFormService qfCreateFormService;
    @Autowired
    private TokenService tokenService;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:create:list')")
    @GetMapping("/list")
    public TableDataInfo list(QfCreateForm qfCreateForm)
    {
        startPage();
        List<QfCreateForm> list = qfCreateFormService.selectQfCreateFormList(qfCreateForm);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:create:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QfCreateForm qfCreateForm)
    {
        List<QfCreateForm> list = qfCreateFormService.selectQfCreateFormList(qfCreateForm);
        ExcelUtil<QfCreateForm> util = new ExcelUtil<QfCreateForm>(QfCreateForm.class);
        return util.exportExcel(list, "form");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('survey:create:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(qfCreateFormService.selectQfCreateFormById(id));
    }

    /**
     * 上传问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:create:add')")
    @Log(title = "上传文卷", businessType = BusinessType.INSERT)
    @PostMapping("add")
    public AjaxResult add(@RequestBody QfCreateForm qfCreateForm) throws ParseException {
        qfCreateForm.setCreator(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername());
        return toAjax(qfCreateFormService.insertQuestionnaire(qfCreateForm));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:create:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfCreateForm qfCreateForm)
    {
        return toAjax(qfCreateFormService.updateQfCreateForm(qfCreateForm));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:create:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qfCreateFormService.deleteQfCreateFormByIds(ids));
    }
}
