package com.punishment.controller;

import com.punishment.common.R;
import com.punishment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R<Void> removeAll() {
        studentService.clearCirculateCriticism();
        return R.ok();
    }

}
