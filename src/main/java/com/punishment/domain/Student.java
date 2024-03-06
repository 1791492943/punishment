package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
    private Long id;

    /**
     * 学生名称
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 处分等级
     */
    private Double punishmentLevel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}