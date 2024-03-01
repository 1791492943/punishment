package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.User;
import com.punishment.service.UserService;
import com.punishment.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-28 15:51:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




