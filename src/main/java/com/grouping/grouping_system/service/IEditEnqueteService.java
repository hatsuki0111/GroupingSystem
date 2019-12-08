package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.Respondent;

import java.util.List;

public interface IEditEnqueteService {
    List<Enquete> getEditableEnqueteList();

    List<Account> getAccountList();

    List<Respondent> getRespondentList(Enquete enquete);

    List<Option> getOptionList(Enquete enquete);
}
