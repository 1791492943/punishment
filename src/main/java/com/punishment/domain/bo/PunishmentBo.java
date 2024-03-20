package com.punishment.domain.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 处分记录Bo
 */
@Data
public class PunishmentBo implements Serializable {

    /**
     * 学生id
     */
    @NotNull(message = "学生id不能为空")
    private Long studentId;

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