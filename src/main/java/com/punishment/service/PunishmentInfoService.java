package com.punishment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.punishment.domain.PunishmentInfo;
import com.punishment.domain.bo.PunishmentInfoBo;

/**
* @author Administrator
* @description 针对表【punishment_info(处分记录表)】的数据库操作Service
* @createDate 2024-03-05 16:21:40
*/
public interface PunishmentInfoService extends IService<PunishmentInfo> {
    void addLevel(PunishmentInfoBo punishmentInfoBo);

    void setLevel(PunishmentInfoBo punishmentInfoBo);
}
