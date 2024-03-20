package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.domain.bo.PunishmentBo;
import com.punishment.service.PunishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
