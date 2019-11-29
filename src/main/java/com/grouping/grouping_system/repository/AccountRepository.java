package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements IAccountRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Account> find() {
        String sql = "select * from account";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findBy(String accountName) {
        var sql = "select * from account where name = ?";
        return jdbc.query(sql,new BeanPropertyRowMapper<>(Account.class),accountName)
                .stream()
                .findFirst()
                .orElseThrow();
    }

}
