package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName class_student
 */
@TableName(value ="class_student")
@Data
public class ClassStudent implements Serializable {
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
     * 班级id
     */
    private Long classInfoId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}