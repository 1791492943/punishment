package com.punishment.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.punishment.domain.Punishment;
import com.punishment.domain.Student;
import com.punishment.domain.bo.PunishmentBo;
import com.punishment.mapper.PunishmentMapper;
import com.punishment.mapper.StudentMapper;
import com.punishment.service.PunishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @description 针对表【punishment(处分记录表)】的数据库操作Service实现
 * @createDate 2024-03-19 14:06:57
 */
@Service
@RequiredArgsConstructor
public class PunishmentServiceImpl extends ServiceImpl<PunishmentMapper, Punishment>
        implements PunishmentService {

    private final StudentMapper studentMapper;

    /**
     * 新增处分
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBo(PunishmentBo punishmentBo) {
        if (ObjectUtils.isEmpty(punishmentBo.getNewLevel()) && ObjectUtils.isEmpty(punishmentBo.getChangeLevel()))
            throw new RuntimeException("处分等级和处分等级变化不能同时为空！");
        if (ObjectUtils.isNotEmpty(punishmentBo.getNewLevel()) && ObjectUtils.isNotEmpty(punishmentBo.getChangeLevel()))
            throw new RuntimeException("处分等级和处分等级变化不能同时存在！");

        Student student = studentMapper.selectById(punishmentBo.getStudentId());

        Punishment punishment = new Punishment();
        BeanUtils.copyProperties(punishmentBo,punishment,"oldLevel","newLevel","changeLevel");
        punishment.setOldLevel(student.getPunishmentLevel());
        if (punishmentBo.getChangeLevel() != null) {
            punishment.setChangeLevel(punishmentBo.getChangeLevel());
            punishment.setNewLevel(Math.floor(punishment.getOldLevel() + punishmentBo.getChangeLevel()));
        } else if (punishmentBo.getNewLevel() != null) {
            punishment.setNewLevel(punishmentBo.getNewLevel());
            punishment.setChangeLevel(punishmentBo.getNewLevel() - punishment.getOldLevel());
        }

        student.setPunishmentLevel(punishment.getOldLevel() + punishment.getChangeLevel());
        baseMapper.insert(punishment);
        studentMapper.updateById(student);
    }
}




