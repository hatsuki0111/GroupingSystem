package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.EvaluationGrade;

import java.util.List;

public interface IEvaluationGradeRepository {
    List<EvaluationGrade> find();

    List<EvaluationGrade> find(long evaluationId, String evaluatorName, String evaluateeName);
}
