package com.ruoyi.web.controller.file;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.file.domain.QfModel;
import com.ruoyi.file.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @date 2020/9/15 -- 17:47
 **/
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    @Autowired
    private FileServiceImpl fileService;
    /**
     * 上传模板
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            QfModel qfModel = new QfModel();
            qfModel.setModelName(fileName);
            qfModel.setModelUrl(filePath);
            fileService.insertFile(qfModel);
            return AjaxResult.success();
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
