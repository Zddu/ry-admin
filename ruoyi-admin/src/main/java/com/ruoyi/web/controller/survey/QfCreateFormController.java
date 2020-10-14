package com.ruoyi.web.controller.survey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.file.service.IFileService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.survey.domain.QfKeyName;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfUserFormVo;
import com.ruoyi.survey.service.*;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.swing.*;


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
    @Autowired
    private IQfSchoolAnswerService qfSchoolAnswerService;
    @Autowired
    private IFileService fileService;
    @Autowired
    private IQfCreateModelService qfCreateModelService;
    /**
     * 获取已创建问卷详细信息
     */
    @PreAuthorize("@ss.hasPermi('survey:create:list')")
    @GetMapping("/list")
    public TableDataInfo getInfo(QfCreateForm qfCreateForm) {
        String username = tokenService.getLoginUser(ServletUtils.getRequest()).getUsername();
        startPage();
        List<QfCreateForm> qfCreateForms = qfCreateFormService.selectQfCreateFormByUsername(username, qfCreateForm);
        return getDataTable(qfCreateForms);
    }

    /**
     * 上传问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:create:add')")
    @Log(title = "上传问卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add( @RequestParam String title, @RequestBody String strData, @RequestParam Boolean isModel)  {
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(strData) ) {
            return AjaxResult.error("请填写必填数据");
        }
        QfCreateForm qfCreateForm = new QfCreateForm();
        qfCreateForm.setStrData(strData);
        qfCreateForm.setTitle(title);
        qfCreateForm.setCreateTime(new Date());
        qfCreateForm.setCreator(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername());

        return toAjax(qfCreateFormService.insertQuestionnaireCustom(qfCreateForm,isModel));
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
     * 撤回问卷
     */
     @PostMapping
     public AjaxResult withdraw(@RequestBody QfUserFormVo qfUserFormVo){
         return toAjax(qfCreateFormService.withdrawQfCreateForm(qfUserFormVo));
     }
    /**
     * 返回学校列表
     */
    @GetMapping("/listSchool")
    public AjaxResult listSchool() {
        AjaxResult success = AjaxResult.success();
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        List<TreeSelect> treeSelects = deptService.buildDeptTreeSelect(depts);
//        success.put("schools", deptService.selectSchoolList());
        success.put("schools", treeSelects.get(0).getChildren());
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
     * 导出问卷题目
     */
    @Log(title = "导出问卷题目", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('survey:list:export')")
    @GetMapping("/export/{id}")
    public AjaxResult exportDetail(@PathVariable("id") Long id) {
        List<String> list=new ArrayList<>();
        List<QfKeyName> qfKeyNames = qfKeyNameService.selectQfKeyNameList(new QfKeyName().setCreateId(id));
        list.add("学校名称");
        for (QfKeyName qfKeyName : qfKeyNames) {
            list.add(qfKeyName.getName());
        }
       return com.ruoyi.survey.util.ExcelUtil.emloyeeExcel(list, qfCreateFormService.selectQfCreateFormById(id).getTitle()+".xlsx");
    }

    /**
     * 导出已填写的问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:list:export')")
    @Log(title = "导出已填写的问卷", businessType = BusinessType.EXPORT)
    @GetMapping("/exportAll/{id}/{mid}")
    public AjaxResult export(@PathVariable("id") Long cid,@PathVariable(value = "mid",required = false)Long mid) {
        if (mid==-1){
            return  qfSchoolAnswerService.exportQfSchoolAnswer(cid);
        }
        return  qfSchoolAnswerService.exportQfSchoolAnswerByModel(cid,mid);
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
            @RequestParam String title,
            @RequestBody String strData) throws ParseException {
        QfCreateForm qfCreateForm = new QfCreateForm();
        qfCreateForm.setId(id);
        qfCreateForm.setStrData(strData);
        qfCreateForm.setTitle(title);
        return toAjax(qfCreateFormService.updateQfCreateForm(qfCreateForm));


    }
    /**
     * 问卷详情
     */
    @PreAuthorize("@ss.hasPermi('survey:list:detail')")
    @GetMapping("/detail")
    public AjaxResult edit(@RequestParam Long id) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("schools",qfUserFormService.selectQfUserFormList(new QfUserForm(id)));
        ajaxResult.put("form",qfCreateFormService.selectQfCreateFormById(id));
        return ajaxResult;
    }

    /**
     * 查看学校提交问卷详情
     */
    @GetMapping("/{sid}/{cid}")
    public AjaxResult showSchoolMsg(@PathVariable("sid")Long sid,@PathVariable("cid")Long cid ) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("survey",qfCreateFormService.selectQfCreateFormById(cid));
        //sid为发布学校问卷表的id
        ajaxResult.put("answer",qfSchoolAnswerService
                .selectQfSchoolAnswerListBySId(
                        cid,
                        qfUserFormService.
                            selectQfUserFormById(sid).getSchoolId().longValue(),
                        0
                )
        );
        return ajaxResult;
    }

    /**
     * 修改状态
     */
    @Log(title = "更新问卷状态", businessType = BusinessType.UPDATE)
    @PutMapping("/update")
     public AjaxResult updateQfState(@RequestBody QfUserForm stateVo){
        return toAjax(qfUserFormService.updateQfUserForm(stateVo));
     }
    /**
     * 下载模板列表
     */
    @GetMapping("/model/list")
    public AjaxResult getModelList(){
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("models",fileService.selectAllModel());
        return ajaxResult;
    }

    /**
     * 选择发布问卷模板
     */
    @GetMapping("/create/model")
    public AjaxResult getCreateModelList(){
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("models",qfCreateModelService.selectQfCreateModelList(null));
        return ajaxResult;
    }

    /**
     * 取消发布
     */
    @PutMapping("/unpublish")
    public AjaxResult unpublish(@RequestParam("id") Long id){
        return toAjax(qfUserFormService.unpublishQfUserForm(id));
    }
}

