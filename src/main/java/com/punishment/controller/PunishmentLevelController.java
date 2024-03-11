package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.domain.PunishmentLevelInfo;
import com.punishment.service.PunishmentLevelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处分等级控制器
 */

@RestController
@RequestMapping("/punishmentLevel")
public class PunishmentLevelController {

    @Autowired
    private PunishmentLevelInfoService punishmentLevelInfoService;

    /**
     * 查询处分等级列表
     */
    @GetMapping
    public R<List<PunishmentLevelInfo>> list() {
        List<PunishmentLevelInfo> list = punishmentLevelInfoService.lambdaQuery().orderByAsc(PunishmentLevelInfo::getPunishmentLevel).list();
        return R.ok(list);
    }

    /**
     * 添加处分等级
     */
    @PostMapping
    public R<Void> add(@RequestBody PunishmentLevelInfo punishmentLevelInfo) {
        punishmentLevelInfoService.save(punishmentLevelInfo);
        return R.ok();
    }

    /**
     * 修改处分等级
     */
    @PutMapping
    public R<Void> update(@RequestBody PunishmentLevelInfo punishmentLevelInfo) {
        punishmentLevelInfoService.updateById(punishmentLevelInfo);
        return R.ok();
    }

    /**
     * 删除处分等级
     */
    @DeleteMapping("/{ids}")
    public R<Void> delete(@PathVariable List<Long> ids) {
        punishmentLevelInfoService.removeByIds(ids);
        return R.ok();
    }

}
