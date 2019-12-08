package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.Respondent;
import com.grouping.grouping_system.repository.IAccountRepository;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import com.grouping.grouping_system.repository.IOptionRepository;
import com.grouping.grouping_system.repository.IRespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateEnqueteService implements ICreateEnqueteService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Autowired
    private IOptionRepository optionRepository;

    @Autowired
    private IRespondentRepository respondentRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.find();
    }

    @Transactional
    @Override
    public void registerEnquete(Enquete enquete, List<String> optionList, List<String> respondentList) {
        enquete.setPostedDateTime(LocalDateTime.now());
        var enqueteId = enqueteRepository.insert(enquete);
        var options = new ArrayList<Option>();
        for (var label : optionList){
            options.add(new Option(enqueteId,label,true));
        }
        optionRepository.insert(options);
        var respondents = new ArrayList<Respondent>();
        for (var name : respondentList){
            respondents.add(new Respondent(enqueteId,name));
        }
        respondentRepository.insert(respondents);
    }
}
