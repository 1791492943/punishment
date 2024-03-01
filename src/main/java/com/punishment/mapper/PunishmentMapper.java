package com.punishment.mapper;

import com.punishment.domain.Punishment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【punishment】的数据库操作Mapper
* @createDate 2024-02-28 15:51:58
* @Entity com.punishment.domain.Punishment
*/
@Mapper
public interface PunishmentMapper extends BaseMapper<Punishment> {

}




