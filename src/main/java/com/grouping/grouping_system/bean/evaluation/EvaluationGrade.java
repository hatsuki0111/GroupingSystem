package com.grouping.grouping_system.bean.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EvaluationGrade implements Serializable {
    private long evaluationItemId;
    private String name;
    private int grade;

    public EvaluationGrade() {
        this(0, "", 0);
    }
}
