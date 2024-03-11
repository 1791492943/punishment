package com.punishment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.punishment.domain.ClassInfo;

/**
* @author Administrator
* @description 针对表【class_info(班级表)】的数据库操作Service
* @createDate 2024-03-05 16:21:40
*/
public interface ClassInfoService extends IService<ClassInfo> {

    void insert(ClassInfo classInfo);

    void updateByIdCheck(ClassInfo classInfo);
}
