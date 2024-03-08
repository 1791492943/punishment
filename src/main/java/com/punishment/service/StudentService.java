package com.punishment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.punishment.common.PageQuery;
import com.punishment.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.punishment.domain.bo.StudentBo;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Service
* @createDate 2024-03-05 16:21:40
*/
public interface StudentService extends IService<Student> {

    void clearCirculateCriticism();

    void saveStudentBo(StudentBo studentBo);

    void updateStudentBo(StudentBo studentBo);

    Page<Student> getPage(Student student, PageQuery pageQuery);
}
