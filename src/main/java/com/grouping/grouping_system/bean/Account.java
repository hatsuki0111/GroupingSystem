package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * アカウント
 */
@AllArgsConstructor
@Data
public class Account {
    private String name;
    private String password;

    public Account(){
        this("","");
    }
}
