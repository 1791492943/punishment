package com.punishment.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.punishment.conversion.StringDoubleConverter;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentExcelVo {

    /**
     * 学号
     */
    @ExcelProperty("学号")
    private String studentCode;

    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    @NotBlank(message = "学号不能为空")
    private String name;

    /**
     * 性别
     */
    @ExcelProperty("性别（男/女）")
    private String sex;

    /**
     * 处分等级
     */
    @ExcelProperty(value = "处分等级（正常/通报批评/警告/严重警告/记过/留校察看）" ,converter = StringDoubleConverter.class)
    private Double punishmentLevel;

    /**
     * 通报批评
     */
    @ExcelProperty(value = "通报批评（是/否）")
    private String circulateCriticism;

}
