package com.punishment.mapper;

import com.punishment.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2024-03-19 14:06:57
* @Entity com.punishment.domain.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    void clearCirculateCriticism();
}




