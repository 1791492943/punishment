package com.punishment.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.punishment.domain.bo.StudentBo;
import com.punishment.domain.vo.StudentExcelVo;
import com.punishment.service.StudentService;
import com.punishment.util.SpringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class StudentListener implements ExcelListener<StudentExcelVo> {

    private Validator validator;
    private Integer failNum = 0;
    private StringBuilder failMsg = new StringBuilder();
    private Integer successNum = 0;
    private final StudentService studentService;

    public StudentListener() {
        this.validator = SpringUtils.getBean(Validator.class);
        this.studentService = SpringUtils.getBean(StudentService.class);
    }

    @Override
    public void invoke(StudentExcelVo studentExcelVo, AnalysisContext analysisContext) {
        try {
            // 初步校验
            validator.validateObject(studentExcelVo);

            // 查询学生是否重复
            StudentBo studentBo = new StudentBo();
            BeanUtils.copyProperties(studentExcelVo,studentBo);
            studentService.checkStudent(studentBo);

            // 是否加上通报批评
            if("是".equals(studentExcelVo.getCirculateCriticism())){
                studentBo.setPunishmentLevel(studentBo.getPunishmentLevel() + 0.5);
            }

            // 保存学生
            studentService.saveBo(studentBo);
            successNum++;
        } catch (Exception e) {
            failNum++;
            failMsg.append("<br/>").append("第 ").append(successNum + failNum + 1).append(" 行 ").append(e.getMessage());
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public ExcelResult<StudentExcelVo> getExcelResult() {
        return new ExcelResult<>() {
            @Override
            public String getAnalysis() {
                if (failNum > 0) {
                    failMsg.insert(0, "很抱歉，导入失败！共 " + failNum + " 条数据格式不正确，错误如下：");
                    throw new RuntimeException(failMsg.toString());
                }
                return "恭喜您，数据已全部导入成功！共 " + successNum + " 条";
            }

            @Override
            public List<StudentExcelVo> getList() {
                return null;
            }

            @Override
            public List<String> getErrorList() {
                return null;
            }
        };
    }
}
