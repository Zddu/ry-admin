package com.ruoyi.assets.domain.vo;

import lombok.Data;

/**
 * @date 2020/9/18 -- 17:45
 **/
@Data
public class ReceiverVo {
    /** 部门ID */
    private Long deptId;
    private String deptName;
    private int itemNum = 0;
}
