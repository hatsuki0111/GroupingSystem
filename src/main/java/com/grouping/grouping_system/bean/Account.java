package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * アカウント
 */
@AllArgsConstructor
@Data
public class Account implements Serializable {
    private String name;
    private String password;

    public Account(){
        this("","");
    }
}