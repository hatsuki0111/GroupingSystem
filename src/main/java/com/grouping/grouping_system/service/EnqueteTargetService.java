package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.AccountNameCheck;
import com.grouping.grouping_system.repository.AccountRepository;
import com.grouping.grouping_system.repository.EnqueteRepository;
import com.grouping.grouping_system.repository.IAccountRepository;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnqueteTargetService implements IEnqueteTargetService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Override
    public List<Account> nantoka() {
        return accountRepository.find();
    }

    @Override
    public List<AccountNameCheck> getAccountName() {
        return accountRepository.findName();
    }
}
