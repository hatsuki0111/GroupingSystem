package com.grouping.grouping_system.bean.evaluation;

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
public class Evaluation implements Serializable {
    private long id;
    private long enqueteId;
    private String evaluatorName;
    private String evaluateeName;

    public Evaluation(){
        this(0,0,"","");
    }
}
