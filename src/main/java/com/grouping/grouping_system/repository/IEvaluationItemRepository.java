package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.EvaluationItem;

import java.util.List;

public interface IEvaluationItemRepository {
    List<EvaluationItem> find(long enqueteId);

}
