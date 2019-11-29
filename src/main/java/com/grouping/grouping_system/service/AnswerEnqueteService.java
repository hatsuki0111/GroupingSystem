package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.repository.IEnqueteRepository;
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

    @Override
    public List<Enquete> getAnswerableEnqueteList() {
        return enqueteRepository.findBy(SigningSession.get().getAccountName());
    }

    @Override
    public boolean isAnswerable(Enquete enquete) {
        return enquete.getStartDateTime().isBefore(LocalDateTime.now()) && !enquete.getEndDateTime().isBefore(LocalDateTime.now());
    }
}
