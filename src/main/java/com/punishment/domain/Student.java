package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 主键
     */
    @TableId
    @NotEmpty(message = "主键不能为空")
    private Long id;

    /**
     * 学号
     */
    private String studentCode;

    /**
     * 学生名称
     */
    @NotBlank(message = "学生名称不能为空")
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 处分等级
     */
    @NotEmpty(message = "处分等级不能为空")
    private Double punishmentLevel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}