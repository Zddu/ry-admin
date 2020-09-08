package com.ruoyi.web.controller.survey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfUserFormVo;
import com.ruoyi.survey.service.IQfKeyNameService;
import com.ruoyi.survey.service.IQfUserFormService;
import com.ruoyi.system.service.ISysDeptService;
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

import javax.servlet.http.HttpServletResponse;

/**
 * 【创建问卷】Controller
 *
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@RestController
@RequestMapping("/survey/create")
public class QfCreateFormController extends BaseController {
    @Autowired
    private IQfCreateFormService qfCreateFormService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private IQfKeyNameService qfKeyNameService;
    @Autowired
    private IQfUserFormService qfUserFormService;
    /**
     * 获取已创建问卷详细信息
     */
    @PreAuthorize("@ss.hasPermi('survey:create:list')")
    @GetMapping("/list")
    public TableDataInfo getInfo(QfCreateForm qfCreateForm) {
        startPage();
        List<QfCreateForm> qfCreateForms = qfCreateFormService.selectQfCreateFormByUsername(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername(), qfCreateForm);
        return getDataTable(qfCreateForms);
    }

    /**
     * 上传问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:create:add')")
    @Log(title = "上传问卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestParam String endTime, @RequestParam String title, @RequestBody String strData) throws ParseException {
        if (endTime == null || title == null || strData == null) {
            return AjaxResult.error("请填写必填数据");
        }
        QfCreateForm qfCreateForm = new QfCreateForm();
        qfCreateForm.setStrData(strData);
        qfCreateForm.setTitle(title);
        qfCreateForm.setCreateTime(new Date());
        qfCreateForm.setCreator(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername());
        qfCreateForm.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime));

        return toAjax(qfCreateFormService.insertQuestionnaire(qfCreateForm));
    }

    /**
     * 发布问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:list:out')")
    @Log(title = "发布问卷", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfUserFormVo qfUserFormVo) {
        return toAjax(qfCreateFormService.submitQfCreateForm(qfUserFormVo));
    }

    /**
     * 返回学校列表
     */
    @GetMapping("/listSchool")
    public AjaxResult listSchool() {
        AjaxResult success = AjaxResult.success();
        success.put("schools", deptService.selectSchoolList());
        return success;
    }

    /**
     * 删除已上传问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:list:remove')")
    @Log(title = "删除已上传问卷", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(qfCreateFormService.deleteQfCreateFormByIds(ids));
    }

    /**
     * 导出创建问卷
     */
    @Log(title = "导出创建问卷", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('survey:list:export')")
    @GetMapping("/export")
    public AjaxResult export() {
        List<QfCreateForm> qfCreateForms = qfCreateFormService.selectQfCreateFormByUsername(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername(), new QfCreateForm());
        ExcelUtil<QfCreateForm> util = new ExcelUtil<>(QfCreateForm.class);
        return util.exportExcel(qfCreateForms, "创建问卷");
    }
    /**
     * 导出问卷明细
     */
    @Log(title = "导出问卷明细", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('survey:list:export')")
    @GetMapping("/export/{id}")
    public void exportDetail(HttpServletResponse response,@PathVariable("id") Long id) {
        Map<String,List<String>> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        List<QfKeyName> qfKeyNames = qfKeyNameService.selectQfKeyNameList(new QfKeyName().setCreateId(id));
        for (QfKeyName qfKeyName : qfKeyNames) {
            list.add(qfKeyName.getName());
        }
        map.put("titleList",list);
        com.ruoyi.survey.util.ExcelUtil.exportExcel(
                map,
                "test.ftl",
                response,
                qfCreateFormService.selectQfCreateFormById(id).getTitle()
        );
    }
    /**
     * 返回编辑信息
     */
    @GetMapping("/get-edit-data/{id}")
    public AjaxResult showEditQfCreateForm(@PathVariable Long id) {
        return AjaxResult.success(qfCreateFormService.selectQfCreateFormById(id));
    }

    /**
     * 修改问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:list:edit')")
    @Log(title = "修改问卷", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(
            @RequestParam Long id,
            @RequestParam String endTime,
            @RequestParam String title,
            @RequestBody String strData) throws ParseException {
        QfCreateForm qfCreateForm = new QfCreateForm();
        qfCreateForm.setId(id);
        qfCreateForm.setStrData(strData);
        qfCreateForm.setTitle(title);
        Date parse = null;
        try {
            parse=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        }finally {
            qfCreateForm.setEndTime(parse);
            return toAjax(qfCreateFormService.updateQfCreateForm(qfCreateForm));
        }

    }
    /**
     * 问卷详情
     */
    @PreAuthorize("@ss.hasPermi('')")
    @GetMapping("/")
    public AjaxResult edit(@RequestParam Long id) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("schools",qfUserFormService.selectQfUserFormList(new QfUserForm(id,null,null)));
        ajaxResult.put("form",qfCreateFormService.selectQfCreateFormById(id));
        return ajaxResult;
    }

}
