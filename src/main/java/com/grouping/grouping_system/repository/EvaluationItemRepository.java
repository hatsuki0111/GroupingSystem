package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.EvaluationItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    public List<EvaluationItem> find(long enqueteId) {
        var sql = "select EVALUATION_ITEM_ID as ID, NAME from ENQUETE_EVALUATION_ITEM " +
                "inner join EVALUATION_ITEM on ENQUETE_EVALUATION_ITEM.EVALUATION_ITEM_ID = EVALUATION_ITEM.ID " +
                "where ENQUETE_ID = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(EvaluationItem.class), enqueteId);
    }
}
