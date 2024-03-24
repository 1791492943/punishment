package com.punishment.controller;

import com.punishment.common.PageQuery;
import com.punishment.common.R;
import com.punishment.common.TableData;
import com.punishment.domain.Punishment;
import com.punishment.domain.bo.PunishmentBo;
import com.punishment.domain.bo.PunishmentInfoBo;
import com.punishment.service.PunishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/punishment")
@RequiredArgsConstructor
public class PunishmentController {

    private final PunishmentService punishmentService;

    /**
     * 新增处分
     */
    @PostMapping
    public R<Void> save(@RequestBody @Validated PunishmentBo punishmentBo) {
        punishmentService.saveBo(punishmentBo);
        return R.ok();
    }

    @GetMapping
    public TableData<Punishment> page(PunishmentInfoBo punishmentInfoBo, PageQuery pageQuery) {
        return null;
    }

}
