package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.Respondent;
import com.grouping.grouping_system.repository.IAccountRepository;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import com.grouping.grouping_system.repository.IOptionRepository;
import com.grouping.grouping_system.repository.IRespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditEnqueteService implements IEditEnqueteService {

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRespondentRepository respondentRepository;

    @Autowired
    private IOptionRepository optionRepository;

    @Override
    public List<Enquete> getEditableEnqueteList(){
        return enqueteRepository.findBy(SigningSession.get().getAccountName());
    }

    @Override
    public List<Account> getAccountList(){
        return accountRepository.find();
    }

    @Override
    public List<Respondent> getRespondentList(Enquete enquete){
        return respondentRepository.findBy(enquete.getId());
    }

    @Override
    public List<Option> getOptionList(Enquete enquete){
        return optionRepository.findBy(enquete.getId());
    }
}
