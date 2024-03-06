package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.ClassInfo;
import com.punishment.service.ClassInfoService;
import com.punishment.mapper.ClassInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【class_info(班级表)】的数据库操作Service实现
* @createDate 2024-03-05 16:21:40
*/
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo>
    implements ClassInfoService{

}



