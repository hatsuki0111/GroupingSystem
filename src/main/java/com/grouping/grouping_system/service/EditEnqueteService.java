package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.*;
import com.grouping.grouping_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ISelectedOptionRepository selectedOptionRepository;

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

    @Override
    public void editEnquete(Enquete enquete, List<String> respondentList, List<String> optionList){
        enqueteRepository.update(enquete);
        respondentRepository.delete(enquete.getId());
        var respondents = new ArrayList<Respondent>();
        for (var name : respondentList){
            respondents.add(new Respondent(enquete.getId(),name));
        }
        respondentRepository.insert(respondents);
        optionRepository.delete(enquete.getId());
        var options = new ArrayList<Option>();
        for (var o : optionList){
            options.add(new Option(enquete.getId(),o,true));
        }
        optionRepository.insert(options);
        selectedOptionRepository.delete(enquete.getId());
    }
}