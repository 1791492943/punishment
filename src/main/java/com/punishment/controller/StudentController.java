package com.punishment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.punishment.common.PageQuery;
import com.punishment.common.R;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学生控制器
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 添加学生
     */
    @PostMapping
    public R<Void> add(@RequestBody StudentBo studentBo) {
        studentService.saveStudentBo(studentBo);
        return R.ok();
    }

    /**
     * 修改学生
     */
    @PutMapping
    public R<Void> update(@RequestBody StudentBo studentBo){
        studentService.updateStudentBo(studentBo);
        return R.ok();
    }

    /**
     * 获取学生列表
     */
    @GetMapping
    public R<Page<Student>> page(Student student, PageQuery pageQuery) {
        Page<Student> page = studentService.getPage(student,pageQuery);
        return R.ok(page);
    }

}
