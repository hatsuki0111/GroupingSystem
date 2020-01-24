package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.evaluation.EvaluationGrade;

import java.util.List;

public interface IEvaluateService {

    List<List<EvaluationGrade>> getEvaluationGrade(long enqueteId);
}
