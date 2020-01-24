package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.evaluation.Evaluation;
import com.grouping.grouping_system.bean.evaluation.view.EvaluationGradeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvaluationGradeRepository implements IEvaluationGradeRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<EvaluationGradeView> find(){
        var sql = "select * from EVALUATION_GRADE";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(EvaluationGradeView.class));
    }

    @Override
    public List<EvaluationGradeView> find(long evaluationId, String evaluatorName, String evaluateeName){
        var sql = "select EVALUATION_ID, NAME, EVALUATION_ITEM_ID, GRADE from EVALUATION_GRADE " +
                "inner join EVALUATION_ITEM on EVALUATION_GRADE.EVALUATION_ITEM_ID = EVALUATION_ITEM.ID " +
                "inner join EVALUATION on EVALUATION_GRADE.EVALUATION_ID = EVALUATION.ID " +
                "where ENQUETE_ID = ? " +
                "and EVALUATOR_NAME = ? " +
                "and EVALUATEE_NAME = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(EvaluationGradeView.class), evaluationId, evaluatorName, evaluateeName);
    }

    @Override
    public void insert(long evaluationId, long evaluationItemId, int grade){
        var sql = "insert into EVALUATION_GRADE(EVALUATION_ID, EVALUATION_ITEM_ID, GRADE) " +
                "VALUES (?, ?, ?)";
        jdbc.update(sql, evaluationId, evaluationItemId, grade);
    }
}
