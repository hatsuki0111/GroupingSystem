package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountNameCheck {
    private String accountName;
    private boolean check;


    public AccountNameCheck(){
        this("",false);
    }
}
