package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 班级表
 * @TableName class_info
 */
@TableName(value ="class_info")
@Data
public class ClassInfo implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 班级名称
     */
    private String className;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}