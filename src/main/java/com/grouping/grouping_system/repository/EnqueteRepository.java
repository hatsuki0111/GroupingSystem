package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
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
        String sql = "insert into enquete(title, author_account_name, start_date_time, end_date_time) values(?,?,?,?)";
//        jdbc.update(sql, enquete.getTitle(), enquete.getAuthorAccountName(),
//                enquete.getStartDateTime(), enquete.getEndDateTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc -> {
            PreparedStatement preparedStatement = psc.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,enquete.getTitle());
            preparedStatement.setString(2,enquete.getAuthorAccountName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(enquete.getStartDateTime()));
            preparedStatement.setTimestamp(4,Timestamp.valueOf(enquete.getEndDateTime()));
            return preparedStatement;
        },keyHolder);
        return (long)keyHolder.getKey();
    }

    @Override
    public List<Enquete> findBy(String accountName) {
        var sql = "select * from enquete where AUTHOR_ACCOUNT_NAME = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Enquete.class),accountName);
    }


}
