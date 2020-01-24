package com.grouping.grouping_system.bean.evaluation.view;

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
public class EvaluationGradeView implements Serializable {
    private long evaluationId;
    private String name;
    private long evaluationItemId;
    private int grade;

    public EvaluationGradeView(){
        this(0,"",0,0);
    }
}
