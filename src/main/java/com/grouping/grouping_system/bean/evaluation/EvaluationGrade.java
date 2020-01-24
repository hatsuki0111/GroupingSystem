package com.grouping.grouping_system.bean.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 評価したグレード
 *
 * @author ChocoSotan
 */
@Data
@AllArgsConstructor
public class EvaluationGrade implements Serializable {
    private long evaluationId;
    private String name;
    private long evaluationItemId;
    private int grade;

    public EvaluationGrade(){
        this(0,"",0,0);
    }
}
