package com.grouping.grouping_system.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 評価項目リポジトリ
 *
 * @author ChocoSotan
 */
@Repository
public class EvaluationItemRepository implements IEvaluationItemRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public EvaluationItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Long> find(long enqueteId) {
        var sql = "select EVALUATION_ITEM_ID from ENQUETE_EVALUATION_ITEM where ENQUETE_ID = ?";
        return jdbc.queryForList(sql, Long.class, enqueteId);
    }
}
