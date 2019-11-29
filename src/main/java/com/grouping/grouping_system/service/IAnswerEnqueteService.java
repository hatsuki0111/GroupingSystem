package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Enquete;

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
}
