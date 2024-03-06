package com.punishment.mapper;

import com.punishment.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user(后台用户表)】的数据库操作Mapper
* @createDate 2024-03-05 16:21:40
* @Entity com.punishment.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




