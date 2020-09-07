package com.ruoyi.survey.domain.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

}
