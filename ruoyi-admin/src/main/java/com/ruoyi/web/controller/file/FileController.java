package com.ruoyi.web.controller.file;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.file.domain.QfModel;
import com.ruoyi.file.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @date 2020/9/15 -- 17:47
 **/
@RestController
@RequestMapping("/file/model")
public class FileController extends BaseController {
    @Autowired
    private FileServiceImpl fileService;
    /**
     * 上传模板
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file)  {
        try {
            // 上传文件路径
            String fileUploadPath = RuoYiConfig.getUploadPath()+"/"+ DateUtils.datePath() +"/";
            //上传文件所在路径
            String fileAllUrl = fileUploadPath+file.getOriginalFilename();
            QfModel qfModel = new QfModel();
            qfModel.setModelName(file.getOriginalFilename());
            qfModel.setModelUrl(fileAllUrl);
            // 上传并返回新文件名称
            List<QfModel> qfModels = fileService.selectAllModel();
            for (QfModel model : qfModels) {
                if (model.getModelName().equals(file.getOriginalFilename())){
                   throw new CustomException("文件已存在");
                }
            }
            FileUploadUtils.uploadFile(fileUploadPath, file);
            fileService.insertFile(qfModel);
            return AjaxResult.success();
        }
        catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 删除模板
     */
    @DeleteMapping("delete/{id}")
    public AjaxResult deleteFile(@PathVariable("id")Long id){
        return toAjax(fileService.deleteModel(id));
    }
}
