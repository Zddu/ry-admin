package com.ruoyi.web.controller.survey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.domain.vo.QfUserFormVo;
import com.ruoyi.system.domain.SysPost;
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
    @Autowired
    private ISysDeptService deptService;
    /**
     * 查询【请填写功能名称】列表
     */
//    @PreAuthorize("@ss.hasPermi('survey:create:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(QfCreateForm qfCreateForm)
//    {
//        startPage();
//        List<QfCreateForm> list = qfCreateFormService.selectQfCreateFormList(qfCreateForm);
//        return getDataTable(list);
//    }

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
     * 获取已创建问卷详细信息
     */
    @PreAuthorize("@ss.hasPermi('survey:create:list')")
    @GetMapping("/list")
    public TableDataInfo getInfo(QfCreateForm qfCreateForm) {
        startPage();
        List<QfCreateForm> qfCreateForms = qfCreateFormService.
                selectQfCreateFormByUsername(tokenService.getLoginUser(ServletUtils.getRequest()).getUsername(),qfCreateForm);
        return getDataTable(qfCreateForms);
    }

    /**
     * 上传问卷
     */
    @PreAuthorize("@ss.hasPermi('survey:create:add')")
    @Log(title = "上传问卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestParam String endTime,@RequestParam String title ,@RequestBody String strData) throws ParseException {
        if (endTime==null||title==null||strData==null){
            return AjaxResult.error("请填写必填数据");
        }
        QfCreateForm qfCreateForm=new QfCreateForm();
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
        success.put("schools",deptService.selectSchoolList());
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

}
