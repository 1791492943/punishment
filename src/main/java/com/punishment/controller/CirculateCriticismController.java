package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.service.PunishmentInfoService;
import com.punishment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通报批评控制器
 */

@RestController
@RequestMapping("/circulateCriticism")
public class CirculateCriticismController {

    @Autowired
    private StudentService studentService;

    /**
     * 删除所有通报批评
     */
    @DeleteMapping("/all")
    public R<String> removeAll() {
        studentService.clearCirculateCriticism();
        return R.ok();
    }

}
