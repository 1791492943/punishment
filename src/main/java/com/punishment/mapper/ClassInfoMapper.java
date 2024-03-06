package com.punishment.mapper;

import com.punishment.domain.ClassInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【class_info(班级表)】的数据库操作Mapper
* @createDate 2024-03-05 16:21:40
* @Entity com.punishment.domain.ClassInfo
*/
@Mapper
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {

}




