package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 处分记录表
 * @TableName punishment
 */
@TableName(value ="punishment")
@Data
public class Punishment implements Serializable {
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
     * 旧处分等级
     */
    private Double oldLevel;

    /**
     * 新处分等级
     */
    private Double newLevel;

    /**
     * 等级变化
     */
    private Double changeLevel;

    /**
     * 描述
     */
    @TableField(value = "`describe`")
    private String describe;

    /**
     * 处分编号
     */
    private Integer code;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}