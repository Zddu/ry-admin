package com.ruoyi.file.service;

import com.ruoyi.file.domain.QfModel;

import java.util.List;

/**
 * @date 2020/9/15 -- 17:54
 **/
public interface IFileService {
    int insertFile(QfModel qfModel);

    List<QfModel> selectAllModel();

    int deleteModel(Long mid);
}
