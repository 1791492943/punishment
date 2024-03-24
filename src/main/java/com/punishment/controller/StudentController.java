package com.punishment.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.punishment.common.PageQuery;
import com.punishment.common.R;
import com.punishment.common.TableData;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.domain.vo.StudentExcelVo;
import com.punishment.domain.vo.StudentVo;
import com.punishment.listener.ExcelResult;
import com.punishment.listener.StudentListener;
import com.punishment.service.StudentService;
import com.punishment.util.ExcelUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.URLEncoder;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生控制器
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    /**
     * 新增学生
     */
    @PostMapping
    public R<Void> save(@RequestBody @Validated StudentBo studentBo) {
        studentService.saveBo(studentBo);
        return R.ok();
    }

    /**
     * 修改学生信息
     */
    @PutMapping
    public R<Void> update(@RequestBody @Validated Student student) {
        studentService.updateById(student);
        return R.ok();
    }

    /**
     * 删除学生
     */
    @DeleteMapping("/{ids}")
    public R<Void> delete(@PathVariable List<Long> ids) {
        studentService.removeByIds(ids);
        return R.ok();
    }

    /**
     * 查询学生
     */
    @GetMapping
    public TableData<StudentVo> page(StudentBo studentBo, PageQuery pageQuery) {
        Page<Student> studentPage = studentService.pageBo(studentBo, pageQuery.build());
        List<StudentVo> collect = studentPage.getRecords().stream().map(StudentVo::new).collect(Collectors.toList());
        return TableData.build(collect);
    }

    /**
     * 获取学生导入模板
     */
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        response.addHeader("Content-Disposition", "attachment;filename=" + new URLEncoder().encode("模板.xlsx", StandardCharsets.UTF_8));
        EasyExcel.write(response.getOutputStream(), StudentExcelVo.class).sheet("模板").doWrite(new ArrayList<>());
    }

    /**
     * 导入学生信息
     */
    @PostMapping("/importExcel")
    public R<String> importExcel(MultipartFile file) throws IOException {
        ExcelResult<StudentExcelVo> result = ExcelUtil.importExcel(file.getInputStream(), StudentExcelVo.class, new StudentListener());
        return R.ok(result.getAnalysis());
    }

}
