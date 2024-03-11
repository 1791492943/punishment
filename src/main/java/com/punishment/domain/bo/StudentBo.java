package com.punishment.domain.bo;

import com.punishment.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentBo {

    private Student student;
    private List<Long> classIds;

}
