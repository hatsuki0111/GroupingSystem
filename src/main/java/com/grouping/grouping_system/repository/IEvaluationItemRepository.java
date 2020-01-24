package com.grouping.grouping_system.repository;

import java.util.List;

public interface IEvaluationItemRepository {
    List<Long> find(long enqueteId);

}
