package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.evaluation.view.EvaluationGradeView;

import java.util.List;

public interface IViewEvaluationResultService {
    List<List<EvaluationGradeView>> getEvaluationGrade(long enqueteId);
}
