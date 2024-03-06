package com.punishment.mapper;

import com.punishment.domain.PunishmentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【punishment_info(处分记录表)】的数据库操作Mapper
* @createDate 2024-03-05 16:21:40
* @Entity com.punishment.domain.PunishmentInfo
*/
@Mapper
public interface PunishmentInfoMapper extends BaseMapper<PunishmentInfo> {

}




