package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SelectedOptionRepository implements ISelectedOptionRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<SelectedOption> find() {
        String sql = "select * from selected_option";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(SelectedOption.class));
    }

    @Override
    public void insert(SelectedOption selectedOption) {
        var sql = "insert into selected_option values(?,?,?)";
        jdbc.update(sql,selectedOption.getAccountName(),selectedOption.getEnqueteId(),selectedOption.getOptionLabel());
    }


    @Override
    public List<SelectedOption> findBy(Option option, long enqueteId){
        var sql = "select * from SELECTED_OPTION where OPTION_LABEL = ? and ENQUETE_ID = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(SelectedOption.class),option.getLabel(),enqueteId);
    }

    @Override
    public void delete(long enqueteId){
        var sql = "delete from SELECTED_OPTION where ENQUETE_ID = ?";
        jdbc.update(sql,enqueteId);
    }
}