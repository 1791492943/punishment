package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 处分等级表
 * @TableName punishment_level
 */
@TableName(value ="punishment_level")
@Data
public class PunishmentLevel implements Serializable {
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