package com.ruoyi.file.mapper;

import com.ruoyi.file.domain.QfModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2020/9/15 -- 18:06
 **/
public interface FileMapper {
    int insertFile(@Param("qfModel") QfModel qfModel);

    List<QfModel> selectAllModel();

    List<QfModel> selectModelByQfModel(@Param("qfModel") QfModel qfModel);

    QfModel selectModelByQfModelId(@Param("mid") Long mid);

    int deleteModel(@Param("mid") Long mid);
}
