package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 处分记录表
 * @TableName punishment_info
 */
@TableName(value ="punishment_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PunishmentInfo implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 处分等级
     */
    private Double punishmentLevel;

    /**
     * 违纪事例
     */
    private String describe;

    /**
     * 处分编号
     */
    private Integer punishmentCode;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}