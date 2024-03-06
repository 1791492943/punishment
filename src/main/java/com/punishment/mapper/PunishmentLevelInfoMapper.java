package com.punishment.mapper;

import com.punishment.domain.PunishmentLevelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【punishment_level_info(处分等级表)】的数据库操作Mapper
* @createDate 2024-03-05 16:21:40
* @Entity com.punishment.domain.PunishmentLevelInfo
*/
@Mapper
public interface PunishmentLevelInfoMapper extends BaseMapper<PunishmentLevelInfo> {

}




