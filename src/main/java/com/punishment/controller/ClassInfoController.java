package com.punishment.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.punishment.common.PageQuery;
import com.punishment.common.R;
import com.punishment.domain.ClassInfo;
import com.punishment.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理
 */

@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

    @Autowired
    private ClassInfoService classInfoService;

    /**
     * 分页查询班级
     */
    @GetMapping
    public R<Page<ClassInfo>> page(ClassInfo classInfo, PageQuery pageQuery) {
        Page<ClassInfo> page = classInfoService.lambdaQuery()
                .like(ObjectUtils.isNotEmpty(classInfo.getClassName()), ClassInfo::getClassName, classInfo.getClassName())
                .page(pageQuery.build());
        return R.ok(page);
    }

    /**
     * 添加班级
     */
    @PostMapping
    public R<Void> add(@RequestBody ClassInfo classInfo) {
        classInfoService.insert(classInfo);
        return R.ok();
    }

    /**
     * 更新班级
     */
    @PutMapping
    public R<Void> update(@RequestBody ClassInfo classInfo) {
        classInfoService.updateByIdCheck(classInfo);
        return R.ok();
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/{ids}")
    public R<Void> delete(@PathVariable List<Long> ids) {
        classInfoService.removeByIds(ids);
        return R.ok();
    }

}
