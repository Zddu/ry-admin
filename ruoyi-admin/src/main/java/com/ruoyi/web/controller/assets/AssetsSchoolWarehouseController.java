package com.ruoyi.web.controller.assets;

import java.util.List;

import com.ruoyi.assets.domain.AssetsOrders;
import com.ruoyi.assets.service.IAssetsOrdersService;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysDeptService;
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
import com.ruoyi.assets.domain.AssetsSchoolWarehouse;
import com.ruoyi.assets.service.IAssetsSchoolWarehouseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学校仓库Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@RestController
@RequestMapping("/assets/school")
public class AssetsSchoolWarehouseController extends BaseController
{
    @Autowired
    private IAssetsSchoolWarehouseService assetsSchoolWarehouseService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ISysDeptService sysDeptService;
    @Autowired
    private IAssetsOrdersService assetsOrdersService;
    /**
     * 查询学校仓库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        startPage();
        List<AssetsSchoolWarehouse> list = assetsSchoolWarehouseService.selectAssetsSchoolWarehouseList(assetsSchoolWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出学校仓库列表
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:export')")
    @Log(title = "学校仓库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        List<AssetsSchoolWarehouse> list = assetsSchoolWarehouseService.selectAssetsSchoolWarehouseList(assetsSchoolWarehouse);
        ExcelUtil<AssetsSchoolWarehouse> util = new ExcelUtil<AssetsSchoolWarehouse>(AssetsSchoolWarehouse.class);
        return util.exportExcel(list, "warehouse");
    }

    /**
     * 获取学校仓库详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsSchoolWarehouseService.selectAssetsSchoolWarehouseById(id));
    }

    /**
     * 新增学校仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:add')")
    @Log(title = "学校仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        return toAjax(assetsSchoolWarehouseService.insertAssetsSchoolWarehouse(assetsSchoolWarehouse));
    }

    /**
     * 修改学校仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:edit')")
    @Log(title = "学校仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsSchoolWarehouse assetsSchoolWarehouse)
    {
        return toAjax(assetsSchoolWarehouseService.updateAssetsSchoolWarehouse(assetsSchoolWarehouse));
    }

    /**
     * 删除学校仓库
     */
    @PreAuthorize("@ss.hasPermi('assets:warehouse:remove')")
    @Log(title = "学校仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(assetsSchoolWarehouseService.deleteAssetsSchoolWarehouseByIds(ids));
    }
    /**
     * 展示订单
     */
    @GetMapping("/show-order")
    public AjaxResult showOrder(Long id){
        AssetsOrders assetsOrders =new AssetsOrders();
        Long schoolId = sysDeptService.selectParentDepByChildId(tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getDeptId());
        assetsOrders.setItemId(id);
        assetsOrders.setReceiverId(schoolId);
        return AjaxResult.success("orders",assetsOrdersService.selectAssetsOrdersList(assetsOrders));
    }
    /**
     * 确认订单
     */
    @PostMapping("/confirm")
    public AjaxResult withdrawalorders(@RequestBody List<Long> assetsOrdersIds) {
        return toAjax(assetsOrdersService.confirmOrders(assetsOrdersIds));
    }
}
