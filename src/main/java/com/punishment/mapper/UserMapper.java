package com.punishment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.punishment.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-02-28 15:35:50
* @Entity com.punishment.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




