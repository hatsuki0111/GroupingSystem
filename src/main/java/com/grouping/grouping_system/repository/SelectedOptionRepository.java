package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.SelectedOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SelectedOptionRepository implements ISelectedRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<SelectedOption> find() {
        String sql = "select * from selected_option";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(SelectedOption.class));
    }
}
