package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionRepository implements IOptionRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Option> find() {
        String sql = "select * from option";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Option.class));
    }
}
