package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
