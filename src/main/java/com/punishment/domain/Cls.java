package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName cls
 */
@TableName(value ="cls")
@Data
public class Cls implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 班级名称
     */
    private String clsName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}