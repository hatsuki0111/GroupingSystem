package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Respondent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RespondentRepository implements IRespondentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Respondent> find() {
        String sql = "select * from respondent";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Respondent.class));
    }

    @Override
    public void insert(List<Respondent> respondentList) {
        for (var l : respondentList) {
            String sql = "insert into respondent(enquete_id, account_name) values(?,?)";
            jdbc.update(sql,l.getEnqueteId(),l.getAccountName());
        }
    }

    @Override
    public List<Respondent> findBy(String accountName){
        var sql = "select * from RESPONDENT where ACCOUNT_NAME = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Respondent.class),accountName);
    }

    @Override
    public List<Respondent> findBy(long enqueteId){
        var sql = "select * from RESPONDENT where ENQUETE_ID = ?";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Respondent.class), enqueteId);
    }
}
