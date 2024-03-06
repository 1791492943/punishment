package com.punishment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.PunishmentInfo;
import com.punishment.domain.Student;
import com.punishment.domain.bo.PunishmentInfoBo;
import com.punishment.mapper.PunishmentInfoMapper;
import com.punishment.service.PunishmentInfoService;
import com.punishment.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【punishment_info(处分记录表)】的数据库操作Service实现
 * @createDate 2024-03-05 16:21:40
 */
@Service
public class PunishmentInfoServiceImpl extends ServiceImpl<PunishmentInfoMapper, PunishmentInfo>
        implements PunishmentInfoService {

    @Autowired
    private StudentService studentService;

    @Override
    @Transactional
    public void addLevel(PunishmentInfoBo punishmentInfoBo) {
        List<Student> studentList = studentService.lambdaQuery().in(Student::getId, punishmentInfoBo.getStudentIds()).list();
        studentList.forEach(item -> item.setPunishmentLevel(item.getPunishmentLevel() + punishmentInfoBo.getPunishmentLevel()));

        List<PunishmentInfo> punishmentInfos = studentList.stream().map(item -> {
            PunishmentInfo punishmentInfo = new PunishmentInfo();
            BeanUtils.copyProperties(punishmentInfoBo, punishmentInfo);
            punishmentInfo.setStudentId(item.getId());
            double floor = Math.floor(item.getPunishmentLevel());
            punishmentInfo.setPunishmentLevel(floor);
            return punishmentInfo;
        }).toList();

        this.saveBatch(punishmentInfos);
        studentService.updateBatchById(studentList);
    }

    @Override
    @Transactional
    public void setLevel(PunishmentInfoBo punishmentInfoBo) {
        List<Student> studentList = studentService.lambdaQuery().in(Student::getId, punishmentInfoBo.getStudentIds()).list();
        studentList.forEach(item -> item.setPunishmentLevel(punishmentInfoBo.getPunishmentLevel()));

        List<PunishmentInfo> punishmentInfos = studentList.stream().map(item -> {
            PunishmentInfo punishmentInfo = new PunishmentInfo();
            BeanUtils.copyProperties(punishmentInfoBo, punishmentInfo);
            punishmentInfo.setStudentId(item.getId());
            return punishmentInfo;
        }).toList();

        this.saveBatch(punishmentInfos);
        studentService.updateBatchById(studentList);
    }
}




