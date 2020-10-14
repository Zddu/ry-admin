package com.ruoyi.web.controller.survey;

import java.util.List;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.survey.domain.QfCreateForm;
import com.ruoyi.survey.service.IQfCreateFormService;
import com.ruoyi.survey.service.IQfSchoolAnswerService;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.survey.domain.QfUserForm;
import com.ruoyi.survey.service.IQfUserFormService;
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
    private TokenService tokenService;
    @Autowired
    private IQfCreateFormService qfCreateFormService;
    @Autowired
    private ISysDeptService sysDeptService;
    @Autowired
    private IQfSchoolAnswerService qfSchoolAnswerService;
    /**
     * 查询学校收到的列表
     */
    @PreAuthorize("@ss.hasPermi('survey:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(QfCreateForm qfUserForm) {
//        Long aLong = sysDeptService.selectParentDepByChildId(tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId());
        Long aLong = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId();
        startPage();
        List<QfCreateForm> list = qfUserFormService.selectQfUserFormListBySId(qfUserForm,aLong);
        return getDataTable(list);
    }

    /**
     * 上传答案
     * @param json 答案json
     * @param cid 表单id
     * @param state 暂存状态：6 提交状态：1
     * @return
     */
    @Log(title = "上传问卷内容", businessType = BusinessType.INSERT)
    @PostMapping("/commit")
    public AjaxResult add(@RequestBody String json,@RequestParam Long cid,@RequestParam Integer state) {
        return toAjax(qfUserFormService.insertAnswer(json,
                tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId()
                ,cid,state));
    }
    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('survey:form:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QfUserForm qfUserForm) {
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
    /**
     * 查看问卷详情
     */
    @GetMapping("/{cid}")
    public AjaxResult showSchoolMsg(@PathVariable("cid")Long cid ) {
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("survey",qfCreateFormService.selectQfCreateFormAndUserFormReasonById(
                cid,
                tokenService.getLoginUser(ServletUtils.getRequest()).
                        getUser().
                        getDeptId())
        );

        ajaxResult.put("answer",qfSchoolAnswerService.selectQfSchoolAnswerListBySId(cid,
                tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId(),
                1)
        );
        return ajaxResult;
    }


}
