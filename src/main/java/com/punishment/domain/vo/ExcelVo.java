package com.punishment.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 导入对象
 */
@Data
public class ExcelVo {

    @ExcelProperty("编号")
    private Integer code;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "性别")
    private String sex;

    @ExcelProperty("班级")
    private String className;

    @ExcelProperty("何种处分")
    private String punishmentLevel;

    @ExcelProperty("违纪事列")
    private String disciplinaryViolations;

    @ExcelProperty("处分编号")
    private String punishmentCode;

    @ExcelProperty("时间")
    private String time;

}
