package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;

import java.util.List;

public interface IAnswerEnqueteService {

    /**
     *
     * @return
     */
    List<Enquete> getAnswerableEnqueteList();

    /**
     *
     * @param enquete
     * @return
     */
    boolean isAnswerable(Enquete enquete);

    /**
     *
     * @param enqueteId
     * @return
     */
    List<Option> getOptionListBy(long enqueteId);

    /**
     *
     * @param enqueteId
     * @param selectedOptionLabel
     */
    void registerSelectedOption(long enqueteId, String selectedOptionLabel);
}
