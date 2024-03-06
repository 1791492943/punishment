package com.punishment.service;

import com.punishment.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Service
* @createDate 2024-03-05 16:21:40
*/
public interface StudentService extends IService<Student> {

    void clearCirculateCriticism();

}