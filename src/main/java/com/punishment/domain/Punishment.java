package com.punishment.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
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
     * 处分等级 (旧)
     */
    private Integer oldLevel;

    /**
     * 处分等级 (新)
     */
    private Integer newLevel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 处分编号
     */
    private Integer numbering;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 时间
     */
    private String time;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}