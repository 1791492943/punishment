package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通报批评控制器
 */

@RestController
@RequestMapping("/circulateCriticism")
@RequiredArgsConstructor
public class CirculateCriticismController {

    private final StudentService studentService;

    /**
     * 删除所有通报批评
     */
    @DeleteMapping("/all")
    public R<Void> removeAll() {
        studentService.clearCirculateCriticism();
        return R.ok();
    }

}
