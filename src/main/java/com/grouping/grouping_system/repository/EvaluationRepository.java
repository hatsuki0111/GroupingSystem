package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 評価リポジトリ
 *
 * @author ChocoSotan
 */
@Repository
public class EvaluationRepository implements IEvaluationRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public EvaluationRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public List<Evaluation> find() {
        var sql = "select * from EVALUATION";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Evaluation.class));
    }

    @Override
    public List<String> findEvaluatorList(long enqueteId){
        var sql = "select EVALUATOR_NAME from EVALUATION where ENQUETE_ID = ?";
        return jdbc.queryForList(sql, String.class, enqueteId);
    }
}
