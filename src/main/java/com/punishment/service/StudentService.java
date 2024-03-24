package com.punishment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Service
* @createDate 2024-03-19 14:06:57
*/
public interface StudentService extends IService<Student> {

    void clearCirculateCriticism();

    /**
     * 新增学生
     */
    void saveBo(StudentBo studentBo);

    /**
     * 查询学生
     */
    Page<Student> pageBo(StudentBo studentBo, Page<Student> build);

    /**
     * 校验学生唯一性
     */
    void checkStudent(StudentBo studentBo);
}
