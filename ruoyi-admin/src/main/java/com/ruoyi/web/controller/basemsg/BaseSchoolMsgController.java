package com.ruoyi.web.controller.basemsg;

import com.ruoyi.basemsg.domain.BaseSchoolMsg;
import com.ruoyi.basemsg.service.IBaseSchoolMsgService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 学校基本信息Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-25
 */
@RestController
@RequestMapping("/basemsg/basemsg")
public class BaseSchoolMsgController extends BaseController
{
    @Autowired
    private IBaseSchoolMsgService baseSchoolMsgService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询学校基本信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BaseSchoolMsg baseSchoolMsg) {

        Long sid = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getParentId();
        baseSchoolMsg.setSchoolId(sid);
        startPage();
        List<BaseSchoolMsg> list = baseSchoolMsgService.selectBaseSchoolMsgList(baseSchoolMsg);
        return getDataTable(list);
    }

    /**
     * 导出学校基本信息列表
     */

//    @Log(title = "学校基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaseSchoolMsg baseSchoolMsg)
    {
        List<BaseSchoolMsg> list = baseSchoolMsgService.selectBaseSchoolMsgList(baseSchoolMsg);
        ExcelUtil<BaseSchoolMsg> util = new ExcelUtil<BaseSchoolMsg>(BaseSchoolMsg.class);
        return util.exportExcel(list, "basemsg");
    }

    /**
     * 获取学校基本信息详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseSchoolMsgService.selectBaseSchoolMsgById(id));
    }

    /**
     * 新增学校基本信息
     */
//    @PreAuthorize("@ss.hasPermi('basemsg:basemsg:add')")
    @Log(title = "学校基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @Valid BaseSchoolMsg baseSchoolMsg) {
        Long sid = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDept().getParentId();

        baseSchoolMsg.setSchoolId(sid);
        return toAjax(baseSchoolMsgService.insertBaseSchoolMsg(baseSchoolMsg));
    }

    /**
     * 修改学校基本信息
     */
//    @PreAuthorize("@ss.hasPermi('basemsg:basemsg:edit')")
    @Log(title = "学校基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseSchoolMsg baseSchoolMsg)
    {
        return toAjax(baseSchoolMsgService.updateBaseSchoolMsg(baseSchoolMsg));
    }

    /**
     * 删除学校基本信息
     */
//    @PreAuthorize("@ss.hasPermi('basemsg:basemsg:remove')")
    @Log(title = "学校基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseSchoolMsgService.deleteBaseSchoolMsgByIds(ids));
    }
}
