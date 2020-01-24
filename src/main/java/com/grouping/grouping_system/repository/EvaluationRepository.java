package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.view.EvaluationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
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
    public List<EvaluationView> find() {
        var sql = "select * from EVALUATION";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(EvaluationView.class));
    }

    @Override
    public List<String> findEvaluatorList(long enqueteId, String evaluateeName){
        var sql = "select EVALUATOR_NAME from EVALUATION " +
                "where ENQUETE_ID = ?" +
                "and EVALUATEE_NAME = ?";
        return jdbc.queryForList(sql, String.class, enqueteId, evaluateeName);
    }

    @Override
    public long insert(long enqueteId, String evaluatorName, String evaluateeName){
        var sql = "insert into EVALUATION(ENQUETE_ID, EVALUATOR_NAME, EVALUATEE_NAME) " +
                "VALUES (?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc -> {
            var preparedStatement = psc.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, enqueteId);
            preparedStatement.setString(2, evaluatorName);
            preparedStatement.setString(3, evaluateeName);
            return preparedStatement;
        }, keyHolder);
        return (long)keyHolder.getKey();
    }
}
