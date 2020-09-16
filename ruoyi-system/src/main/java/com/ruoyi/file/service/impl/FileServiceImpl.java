package com.ruoyi.file.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.file.domain.QfModel;
import com.ruoyi.file.mapper.FileMapper;
import com.ruoyi.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @date 2020/9/15 -- 17:55
 **/
@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public int insertFile(QfModel qfModel) {
        return fileMapper.insertFile(qfModel);
    }

    @Override
    public List<QfModel> selectAllModel() {
        return fileMapper.selectAllModel();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteModel(Long mid) {
        int result = fileMapper.delteModel(mid);
        if (result>0){
            if (!FileUtils.deleteFile(fileMapper.selectModelByQfModelId(mid).getModelUrl())){
                throw new CustomException("删除失败");
            }
        }
        return result;
    }


}
