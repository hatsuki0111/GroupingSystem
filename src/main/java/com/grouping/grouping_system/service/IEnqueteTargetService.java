package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.AccountNameCheck;

import java.util.List;

public interface IEnqueteTargetService { /**
     *
     * @return
     */
    List<Account> nantoka();

    List<AccountNameCheck> getAccountName();
}
