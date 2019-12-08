package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import com.grouping.grouping_system.repository.IOptionRepository;
import com.grouping.grouping_system.repository.IRespondentRepository;
import com.grouping.grouping_system.repository.ISelectedOptionRepository;
import org.apache.wicket.Session;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerEnqueteService implements IAnswerEnqueteService {

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Autowired
    private IOptionRepository optionRepository;

    @Autowired
    private ISelectedOptionRepository selectedOptionRepository;

    @Autowired
    private IRespondentRepository respondentRepository;

    @Override
    public List<Enquete> getAnswerableEnqueteList() {
        return enqueteRepository.findBy(respondentRepository.findBy(SigningSession.get().getAccountName()));
    }

    @Override
    public boolean isAnswerable(Enquete enquete) {
        return enquete.getStartDateTime().isBefore(LocalDateTime.now()) && !enquete.getEndDateTime().isBefore(LocalDateTime.now());
    }

    @Override
    public List<Option> getOptionList(long enqueteId) {
        return optionRepository.findBy(enqueteId);
    }


    @Override
    public void registerSelectedOption(long enqueteId, String selectedOptionLabel) {
        selectedOptionRepository.insert(new SelectedOption(SigningSession.get().getAccountName(),enqueteId,selectedOptionLabel));
    }
}