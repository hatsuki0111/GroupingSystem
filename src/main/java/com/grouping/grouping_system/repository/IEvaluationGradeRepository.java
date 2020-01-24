package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.view.EvaluationGradeView;

import java.util.List;

public interface IEvaluationGradeRepository {
    List<EvaluationGradeView> find();

    List<EvaluationGradeView> find(long evaluationId, String evaluatorName, String evaluateeName);

    void insert(long evaluationId, long evaluationItemId, int grade);
}
