package com.ruoyi.survey.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】对象 qf_user_form
 * 
 * @author Zddeä¸¶
 * @date 2020-09-06
 */
@Data
public class QfUserFormVo {
    private Long createId;
    private List<SchoolVO> schools;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
