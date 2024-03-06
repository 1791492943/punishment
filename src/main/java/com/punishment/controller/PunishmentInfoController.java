package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.domain.bo.PunishmentInfoBo;
import com.punishment.service.PunishmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处分控制器
 */

@RestController
@RequestMapping("/punishment")
public class PunishmentInfoController {

    @Autowired
    private PunishmentInfoService punishmentInfoService;

    /**
     * 添加处分等级
     */
    @PostMapping
    public R<String> addLevel(@RequestBody PunishmentInfoBo punishmentInfoBo){
        punishmentInfoService.addLevel(punishmentInfoBo);
        return R.ok();
    }

    /**
     * 设置处分等级
     */
    @PutMapping
    public R<String> setLevel(@RequestBody PunishmentInfoBo punishmentInfoBo){
        punishmentInfoService.setLevel(punishmentInfoBo);
        return R.ok();
    }

}
