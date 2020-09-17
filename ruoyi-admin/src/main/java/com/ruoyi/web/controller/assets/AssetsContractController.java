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
import com.ruoyi.assets.domain.AssetsContract;
import com.ruoyi.assets.service.IAssetsContractService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@RestController
@RequestMapping("/assets/contract")
public class AssetsContractController extends BaseController
{
    @Autowired
    private IAssetsContractService assetsContractService;

    /**
     * 查询合同列表
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsContract assetsContract)
    {
        startPage();
        List<AssetsContract> list = assetsContractService.selectAssetsContractList(assetsContract);
        return getDataTable(list);
    }

    /**
     * 查询所有合同
     */
    @GetMapping("/all")
    public AjaxResult all(AssetsContract assetsContract) {
        AjaxResult success = AjaxResult.success();
        success.put("contract",assetsContractService.selectAssetsContractList(assetsContract));
        return success;
    }

    /**
     * 导出合同列表
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:export')")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsContract assetsContract)
    {
        List<AssetsContract> list = assetsContractService.selectAssetsContractList(assetsContract);
        ExcelUtil<AssetsContract> util = new ExcelUtil<AssetsContract>(AssetsContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 获取合同详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsContractService.selectAssetsContractById(id));
    }

    /**
     * 新增合同
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:add')")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsContract assetsContract) {
        return toAjax(assetsContractService.insertAssetsContract(assetsContract));
    }



    /**
     * 修改合同
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:edit')")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsContract assetsContract)
    {
        return toAjax(assetsContractService.updateAssetsContract(assetsContract));
    }

    /**
     * 删除合同
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:remove')")
    @Log(title = "合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsContractService.deleteAssetsContractByIds(ids));
    }
}
