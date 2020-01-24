package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.Evaluation;

import java.util.List;

public interface IEvaluationRepository {
    List<Evaluation> find();

    List<String> findEvaluatorList(long enqueteId);
}
