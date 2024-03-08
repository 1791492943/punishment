package com.punishment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.common.PageQuery;
import com.punishment.domain.ClassStudent;
import com.punishment.domain.Student;
import com.punishment.domain.bo.StudentBo;
import com.punishment.mapper.ClassStudentMapper;
import com.punishment.mapper.StudentMapper;
import com.punishment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @description 针对表【student(学生表)】的数据库操作Service实现
 * @createDate 2024-03-05 16:21:40
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private ClassStudentMapper classStudentMapper;

    @Override
    public void clearCirculateCriticism() {
        baseMapper.clearCirculateCriticism();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveStudentBo(StudentBo studentBo) {
        Long count = this.lambdaQuery().eq(Student::getName, studentBo.getStudent().getName()).count();
        if (count > 0) throw new RuntimeException("学生 " + studentBo.getStudent().getName() + " 已经存在");
        this.save(studentBo.getStudent());
        studentBo.getClassIds().forEach(item -> {
            ClassStudent classStudent = new ClassStudent();
            classStudent.setStudentId(studentBo.getStudent().getId());
            classStudent.setClassInfoId(item);
            classStudentMapper.insert(classStudent);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentBo(StudentBo studentBo) {
        boolean b = this.updateById(studentBo.getStudent());
        if (!b) throw new RuntimeException("学生修改失败");
        classStudentMapper.delete(new LambdaQueryWrapper<ClassStudent>()
                .eq(ClassStudent::getStudentId, studentBo.getStudent().getId()));
        studentBo.getClassIds().forEach(item -> {
            ClassStudent classStudent = new ClassStudent();
            classStudent.setStudentId(studentBo.getStudent().getId());
            classStudent.setClassInfoId(item);
            classStudentMapper.insert(classStudent);
        });
    }

    @Override
    public Page<Student> getPage(Student student, PageQuery pageQuery) {
        LambdaQueryChainWrapper<Student> lambdaQueryChainWrapper = this.lambdaQuery()
                .like(ObjectUtils.isNotEmpty(student.getName()), Student::getName, student.getName())
                .eq(ObjectUtils.isNotEmpty(student.getSex()), Student::getSex, student.getSex());

        if (ObjectUtils.isNotEmpty(student.getPunishmentLevel())) {
            lambdaQueryChainWrapper
                    .ge(ObjectUtils.isNotEmpty(student.getPunishmentLevel()), Student::getPunishmentLevel, student.getPunishmentLevel())
                    .lt(ObjectUtils.isNotEmpty(student.getPunishmentLevel()), Student::getPunishmentLevel, student.getPunishmentLevel() + 1);
        }

        return lambdaQueryChainWrapper.page(pageQuery.build());
    }
}




