package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.repository.IAccountRepository;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateEnqueteService implements ICreateEnqueteService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.find();
    }

    @Override
    public int registerEnquete(Enquete enquete){
        return enqueteRepository.insert(enquete);
    }

}
