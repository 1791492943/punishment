package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.ClassStudent;
import com.punishment.service.ClassStudentService;
import com.punishment.mapper.ClassStudentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【class_student】的数据库操作Service实现
* @createDate 2024-03-06 16:34:40
*/
@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentMapper, ClassStudent>
    implements ClassStudentService{

}




