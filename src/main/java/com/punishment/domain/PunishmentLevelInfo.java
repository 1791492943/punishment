package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 处分等级表
 * @TableName punishment_level_info
 */
@TableName(value ="punishment_level_info")
@Data
public class PunishmentLevelInfo implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 处分等级
     */
    private Double punishmentLevel;

    /**
     * 处分描述
     */
    private String punishmentDescribe;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}