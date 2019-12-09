package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.*;

import java.util.List;

public interface IEditEnqueteService {
    List<Enquete> getEditableEnqueteList();

    /**
     *
     * @return
     */
    List<Account> getAccountList();

    /**
     *
     * @param enquete
     * @return
     */
    List<Respondent> getRespondentList(Enquete enquete);

    /**
     *
     * @param enquete
     * @return
     */
    List<Option> getOptionList(Enquete enquete);

    /**
     *
     * @param enquete
     * @param respondentList
     * @param optionList
     */
    void editEnquete(Enquete enquete, List<String> respondentList, List<String> optionList);
}