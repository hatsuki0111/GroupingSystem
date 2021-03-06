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
}
