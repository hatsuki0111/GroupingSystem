package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Respondent;

import java.util.List;

/**
 * {@link Respondent}のリポジトリ
 */
public interface IRespondentRepository {
    /**
     * 全ての{@link Respondent}の{@link List}を返します
     * @return {@link Respondent}の{@link List}
     */
    List<Respondent> find();

    /**
     *
     * @param respondentList
     */
    void insert(List<Respondent> respondentList);

    List<Respondent> findBy(String accountName);

    List<Respondent> findBy(long enqueteId);

    void delete(long enqueteId);
}
