package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.domain.ClassInfo;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public R<Student> add(@RequestBody StudentBo studentBo) {
        studentService.saveStudentBo(studentBo);
        return R.ok();
    }

    /**
     * 修改学生
     */
    @PutMapping
    public R<String> update(@RequestBody StudentBo studentBo){
        studentService.updateStudentBo(studentBo);
        return R.ok();
    }

}
