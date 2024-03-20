package com.punishment.domain.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentBo {

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

}
