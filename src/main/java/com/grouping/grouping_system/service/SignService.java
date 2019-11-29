package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService implements ISignService{
    @Autowired
    private IAccountRepository accountRepository;


    @Override
    public boolean signIn(String accountName, String password) {
            if(accountRepository.findBy(accountName).getPassword().equals(password)){
                //認証成功時の処理
                SigningSession.get().signIn(accountName);
                return true;
            }
            return false;
    }
}