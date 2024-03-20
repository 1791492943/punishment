package com.punishment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2024-03-19 14:06:57
* @Entity com.punishment.domain.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    void clearCirculateCriticism();

    Optional<Student> selectOne(StudentBo studentBo);

    @Select("select * from student where name = #{name}")
    List<Student> selectStudentByName(String name);

    @Select("select * from student where student_code = #{code}")
    Optional<Student> selectStudentByCode(String code);
}




