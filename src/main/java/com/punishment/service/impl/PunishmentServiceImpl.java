package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.Punishment;
import com.punishment.service.PunishmentService;
import com.punishment.mapper.PunishmentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【punishment】的数据库操作Service实现
* @createDate 2024-02-28 15:51:58
*/
@Service
public class PunishmentServiceImpl extends ServiceImpl<PunishmentMapper, Punishment>
    implements PunishmentService{

}




