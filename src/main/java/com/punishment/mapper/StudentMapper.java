package com.punishment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.punishment.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2024-03-05 16:21:40
* @Entity com.punishment.domain.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    void clearCirculateCriticism();
}




