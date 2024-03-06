package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.Student;
import com.punishment.service.StudentService;
import com.punishment.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Service实现
* @createDate 2024-03-05 16:21:40
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Override
    public void clearCirculateCriticism() {
        baseMapper.clearCirculateCriticism();
    }
}




