package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;
import com.grouping.grouping_system.repository.IOptionRepository;
import com.grouping.grouping_system.repository.ISelectedOptionRepository;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewResultService implements IViewResultService {

    @Autowired
    private IOptionRepository optionRepository;

    @Autowired
    private ISelectedOptionRepository selectedOptionRepository;

    @Override
    public List<Option> getOptionList(Enquete enquete){
        return optionRepository.findBy(enquete.getId());
    }

    @Override
    public List<SelectedOption> getSelectedOptionList(Option option, Enquete enquete){
        return selectedOptionRepository.findBy(option,enquete.getId());
    }

}
