package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.evaluation.Evaluation;

import java.util.List;

public interface IEvaluateService {
    public static final int GRADE_MIN = 1;
    public static final int GRADE_MAX = 5;

    List<Evaluation> getEvaluationList(long enqueteId);

    void register(List<Evaluation> evaluationList);
}
