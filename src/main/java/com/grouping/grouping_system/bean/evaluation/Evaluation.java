package com.grouping.grouping_system.bean.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 評価(フォーム入力用)
 *
 * @author ChocoSotan
 */
@Data
@AllArgsConstructor
public class Evaluation implements Serializable {
    private long enqueteId;
    private String evaluatorName;
    private String evaluateeName;
    private List<EvaluationGrade> evaluationGradeList;

    public Evaluation() {
        this(0, "", "", new ArrayList<>());
    }
}
