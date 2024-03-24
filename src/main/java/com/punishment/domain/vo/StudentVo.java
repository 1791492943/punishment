package com.punishment.domain.vo;

import com.punishment.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentVo {

    /**
     * 学生对象
     */
    private Student student;

    /**
     * 是否存在通报批评
     */
    private boolean circulateCriticism;

    public StudentVo(Student student) {
        this.student = student;
        Double punishmentLevel = student.getPunishmentLevel();
        if(punishmentLevel == null) return;
        this.circulateCriticism = punishmentLevel % 1.0 != 0;
    }
}
