package com.punishment.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelVo {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("姓名")
    private String nickName;

    @ExcelProperty("性别")
    private Integer sex;
    @ExcelProperty("班级")
    private String clsName;

    @ExcelProperty("何种处分")
    private String newLevel;

    @ExcelProperty("违纪事列")
    private String remark;

    @ExcelProperty("处分编号")
    private String numbering;

    @ExcelProperty("时间")
    private String time;

}
