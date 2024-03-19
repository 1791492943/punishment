package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
    private Long oldLevel;

    /**
     * 新处分等级
     */
    private Long newLevel;

    /**
     * 等级变化
     */
    private Double changeLevel;

    /**
     * 描述
     */
    private String describe;

    /**
     * 处分编号
     */
    private Integer code;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}