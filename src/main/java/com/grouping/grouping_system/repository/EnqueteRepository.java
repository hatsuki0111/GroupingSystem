package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Respondent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EnqueteRepository implements IEnqueteRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Enquete> find() {
        String sql = "select * from enquete";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Enquete.class));
    }

    @Override
    public long insert(Enquete enquete) {
        String sql = "insert into enquete(title, author_account_name, start_date_time, end_date_time,POSTED_DATE_TIME) values(?,?,?,?,?)";
//        jdbc.update(sql, enquete.getTitle(), enquete.getAuthorAccountName(),
//                enquete.getStartDateTime(), enquete.getEndDateTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc -> {
            PreparedStatement preparedStatement = psc.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,enquete.getTitle());
            preparedStatement.setString(2,enquete.getAuthorAccountName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(enquete.getStartDateTime()));
            preparedStatement.setTimestamp(4,Timestamp.valueOf(enquete.getEndDateTime()));
            preparedStatement.setTimestamp(5,Timestamp.valueOf(enquete.getPostedDateTime()));
            return preparedStatement;
        },keyHolder);
        return (long)keyHolder.getKey();
    }

    @Override
    public List<Enquete> findBy(String authorAccountName) {
        var sql = "select * from enquete where AUTHOR_ACCOUNT_NAME = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Enquete.class),authorAccountName);
    }

    @Override
    @Transactional
    public List<Enquete> findBy(List<Respondent> respondentList){
        var enqueteList = new ArrayList<Enquete>();
        for (var r : respondentList) {
            var sql = "select * from ENQUETE where ID = ?";
            enqueteList.add(jdbc.query(sql, new BeanPropertyRowMapper<>(Enquete.class),r.getEnqueteId())
                    .stream()
                    .findFirst()
                    .orElseThrow());
        }
        return enqueteList;
    }

    @Override
    public void update(Enquete enquete){
        var sql = "update ENQUETE set TITLE = ?,AUTHOR_ACCOUNT_NAME = ?, START_DATE_TIME = ?,END_DATE_TIME = ? where ID = ?";
        jdbc.update(sql,enquete.getTitle(),enquete.getAuthorAccountName(),enquete.getStartDateTime(),enquete.getEndDateTime(),enquete.getId());
    }


}
