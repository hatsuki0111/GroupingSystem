package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;

public interface ISignService {

    /**
     *
     * @param accountName
     * @param password
     * @return
     */
    public boolean signIn(String accountName,String password);

}
