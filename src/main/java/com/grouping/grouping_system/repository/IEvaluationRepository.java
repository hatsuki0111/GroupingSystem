package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.view.EvaluationView;

import java.util.List;

public interface IEvaluationRepository {
    List<EvaluationView> find();

    List<String> findEvaluatorList(long enqueteId, String evaluateeName);

    long insert(long enqueteId, String evaluatorName, String evaluateeName);
}
