package com.ruoyi.survey.controller;

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
import com.ruoyi.survey.domain.QfSchoolAnswer;
import com.ruoyi.survey.service.IQfSchoolAnswerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-08
 */
@RestController
@RequestMapping("/survey/answer")
public class QfSchoolAnswerController extends BaseController
{
    @Autowired
    private IQfSchoolAnswerService qfSchoolAnswerService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:list')")
    @GetMapping("/list")
    public TableDataInfo list(QfSchoolAnswer qfSchoolAnswer)
    {
        startPage();
        List<QfSchoolAnswer> list = qfSchoolAnswerService.selectQfSchoolAnswerList(qfSchoolAnswer);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(QfSchoolAnswer qfSchoolAnswer)
    {
        List<QfSchoolAnswer> list = qfSchoolAnswerService.selectQfSchoolAnswerList(qfSchoolAnswer);
        ExcelUtil<QfSchoolAnswer> util = new ExcelUtil<QfSchoolAnswer>(QfSchoolAnswer.class);
        return util.exportExcel(list, "answer");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(qfSchoolAnswerService.selectQfSchoolAnswerById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QfSchoolAnswer qfSchoolAnswer)
    {
        return toAjax(qfSchoolAnswerService.insertQfSchoolAnswer(qfSchoolAnswer));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfSchoolAnswer qfSchoolAnswer)
    {
        return toAjax(qfSchoolAnswerService.updateQfSchoolAnswer(qfSchoolAnswer));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:answer:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qfSchoolAnswerService.deleteQfSchoolAnswerByIds(ids));
    }
}
