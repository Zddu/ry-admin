package com.ruoyi.web.controller.assets;

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
import com.ruoyi.assets.domain.AssetsItemRecord;
import com.ruoyi.assets.service.IAssetsItemRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 记录表Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@RestController
@RequestMapping("/assets/record")
public class AssetsItemRecordController extends BaseController
{
    @Autowired
    private IAssetsItemRecordService assetsItemRecordService;

    /**
     * 查询记录表列表
     */
    @PreAuthorize("@ss.hasPermi('assets:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsItemRecord assetsItemRecord)
    {
        startPage();
        List<AssetsItemRecord> list = assetsItemRecordService.selectAssetsItemRecordList(assetsItemRecord);
        return getDataTable(list);
    }

    /**
     * 导出记录表列表
     */
    @PreAuthorize("@ss.hasPermi('assets:record:export')")
    @Log(title = "记录表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsItemRecord assetsItemRecord)
    {
        List<AssetsItemRecord> list = assetsItemRecordService.selectAssetsItemRecordList(assetsItemRecord);
        ExcelUtil<AssetsItemRecord> util = new ExcelUtil<AssetsItemRecord>(AssetsItemRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 获取记录表详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsItemRecordService.selectAssetsItemRecordById(id));
    }

    /**
     * 新增记录表
     */
    @PreAuthorize("@ss.hasPermi('assets:record:add')")
    @Log(title = "记录表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsItemRecord assetsItemRecord)
    {
        return toAjax(assetsItemRecordService.insertAssetsItemRecord(assetsItemRecord));
    }

    /**
     * 修改记录表
     */
    @PreAuthorize("@ss.hasPermi('assets:record:edit')")
    @Log(title = "记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsItemRecord assetsItemRecord)
    {
        return toAjax(assetsItemRecordService.updateAssetsItemRecord(assetsItemRecord));
    }

    /**
     * 删除记录表
     */
    @PreAuthorize("@ss.hasPermi('assets:record:remove')")
    @Log(title = "记录表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsItemRecordService.deleteAssetsItemRecordByIds(ids));
    }
}
