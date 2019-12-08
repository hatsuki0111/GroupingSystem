package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;

import java.util.List;

public interface IViewResultService {

    /**
     *
     * @param enquete
     * @return
     */
    List<Option> getOptionList(Enquete enquete);

    /**
     *
     * @param option
     * @param enquete
     * @return
     */
    List<SelectedOption> getSelectedOptionList(Option option, Enquete enquete);
}
