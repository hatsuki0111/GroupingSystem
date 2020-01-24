package com.grouping.grouping_system.bean.evaluation.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 評価
 *
 * @author ChocoSotan
 */
@Data
@AllArgsConstructor
public class EvaluationView implements Serializable {
    private long id;
    private long enqueteId;
    private String evaluatorName;
    private String evaluateeName;

    public EvaluationView(){
        this(0,0,"","");
    }
}
