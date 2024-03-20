package com.punishment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.service.StudentService;
import com.punishment.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【student(学生表)】的数据库操作Service实现
* @createDate 2024-03-19 14:06:57
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    /**
     * 清除学生的通报批评
     */
    @Override
    public void clearCirculateCriticism() {
        baseMapper.clearCirculateCriticism();
    }

    /**
     * 新增学生
     */
    @Override
    public void saveBo(StudentBo studentBo) {
        checkStudent(studentBo);
        Student student = BeanUtil.toBean(studentBo, Student.class);
        baseMapper.insert(student);
    }

    /**
     * 查询学生
     */
    @Override
    public Page<Student> pageBo(StudentBo studentBo, Page<Student> build) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ObjectUtils.isNotEmpty(studentBo.getStudentCode()), Student::getStudentCode, studentBo.getStudentCode());
        queryWrapper.like(ObjectUtils.isNotEmpty(studentBo.getName()), Student::getName, studentBo.getName());
        queryWrapper.eq(ObjectUtils.isNotEmpty(studentBo.getSex()), Student::getSex, studentBo.getSex());
        queryWrapper.eq(ObjectUtils.isNotEmpty(studentBo.getPunishmentLevel()), Student::getPunishmentLevel, studentBo.getPunishmentLevel());
        return this.page(build, queryWrapper);
    }

    /**
     * 校验学生唯一性
     * @param studentBo
     */
    private void checkStudent(StudentBo studentBo) {
        if(ObjectUtils.isEmpty(studentBo.getStudentCode())){
            List<Student> studentList = baseMapper.selectStudentByName(studentBo.getName());
            if (studentList.isEmpty()) return;
            throw new RuntimeException("学生 " + studentBo.getName() + " 已存在,请输入学号确保唯一性");
        }

        baseMapper.selectStudentByCode(studentBo.getStudentCode()).ifPresent(student -> {
            throw new RuntimeException("学号 " + studentBo.getStudentCode() + " 已存在");
        });
    }
}




