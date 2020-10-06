package com.ruoyi.web.controller.assets;

import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.assets.domain.AssetsContract;
import com.ruoyi.assets.service.IAssetsContractService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 合同管理Controller
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@RestController
@RequestMapping("/assets/contract")
public class AssetsContractController extends BaseController
{
    @Autowired
    private IAssetsContractService assetsContractService;

    @Autowired
    private ServerConfig serverConfig;
    /**
     * 查询合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssetsContract assetsContract) {
        startPage();
        List<AssetsContract> list = assetsContractService.selectAssetsContractList(assetsContract);

        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:export')")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AssetsContract assetsContract)
    {
        List<AssetsContract> list = assetsContractService.selectAssetsContractList(assetsContract);
        ExcelUtil<AssetsContract> util = new ExcelUtil<AssetsContract>(AssetsContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 获取合同管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(assetsContractService.selectAssetsContractById(id));
    }

    /**
     * 新增合同管理
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:add')")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssetsContract assetsContract)
    {
        return toAjax(assetsContractService.insertAssetsContract(assetsContract));
    }

    /**
     * 修改合同管理
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:edit')")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssetsContract assetsContract)
    {
        return toAjax(assetsContractService.updateAssetsContract(assetsContract));
    }

    /**
     * 删除合同管理
     */
    @PreAuthorize("@ss.hasPermi('assets:contract:remove')")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(assetsContractService.deleteAssetsContractByIds(ids));
    }

    /**
     * 上传合同
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String mappingName = FileUploadUtils.upload(filePath, file).replace(Constants.RESOURCE_PREFIX,"");

            String originalName=file.getOriginalFilename();
            String path = serverConfig.getUrl() + mappingName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("originalName", originalName);
            ajax.put("mappingName", mappingName);
            ajax.put("path", path);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void fileDownload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request)
    {
        try {
            AssetsContract assetsContract = assetsContractService.selectAssetsContractById(id);
            if (assetsContract==null)
            {
                throw new RuntimeException("合同"+id+"不存在");
            }
            String realFileName =assetsContract.getOriginalName();
            String filePath = RuoYiConfig.getProfile()+ assetsContract.getMappingName();
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("异常");
        }

    }
}
