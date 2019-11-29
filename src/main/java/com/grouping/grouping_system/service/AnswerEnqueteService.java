package com.grouping.grouping_system.service;

import com.grouping.grouping_system.SigningSession;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.repository.IEnqueteRepository;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerEnqueteService implements IAnswerEnqueteService {

    @Autowired
    private IEnqueteRepository enqueteRepository;

    @Override
    public List<Enquete> getAnswerableEnqueteList() {
        return enqueteRepository.findBy(SigningSession.get().getAccountName());
    }
}
