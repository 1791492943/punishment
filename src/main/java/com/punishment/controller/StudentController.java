package com.punishment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.punishment.common.PageQuery;
import com.punishment.common.R;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public R<Page<Student>> page(StudentBo studentBo, PageQuery pageQuery) {
        studentService.pageBo(studentBo, pageQuery.build());
        return R.ok();
    }

}
