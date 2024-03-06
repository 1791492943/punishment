package com.punishment.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PunishmentInfoBo {

    /**
     * 学生id
     */
    private List<Long> studentIds;

    /**
     * 处分等级
     */
    private Double punishmentLevel;

    /**
     * 处分编号
     */
    private Integer punishmentCode;

    /**
     * 违纪事例
     */
    private String describe;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

}
