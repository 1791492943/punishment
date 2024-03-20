package com.punishment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.punishment.domain.Punishment;
import com.punishment.domain.bo.PunishmentBo;

/**
* @author Administrator
* @description 针对表【punishment(处分记录表)】的数据库操作Service
* @createDate 2024-03-19 14:06:57
*/
public interface PunishmentService extends IService<Punishment> {
    /**
     * 新增处分
     */
    void saveBo(PunishmentBo punishmentBo);
}
