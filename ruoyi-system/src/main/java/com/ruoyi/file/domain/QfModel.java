package com.ruoyi.file.domain;

import lombok.Data;

/**
 * @date 2020/9/15 -- 18:02
 **/
@Data
public class QfModel {
    private Integer id;
    private String modelName;
    private String modelUrl;

    public QfModel(Integer id, String modelName, String modelUrl) {
        this.id = id;
        this.modelName = modelName;
        this.modelUrl = modelUrl;
    }

    public QfModel() {
    }
}
