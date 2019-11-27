package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.Respondent;

import java.util.List;

public interface ICreateEnqueteService { /**
     *
     * @return 全ての{@link Account}のリスト
     */
    List<Account> getAccountList();

    /**
     *
     * @param enquete
     * @param optionList
     * @param respondentList
     */
    void registerEnquete(Enquete enquete,List<String> optionList,List<String> respondentList);
}
