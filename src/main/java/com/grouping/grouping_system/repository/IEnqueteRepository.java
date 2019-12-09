package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Enquete;
import com.grouping.grouping_system.bean.Respondent;

import java.util.List;

/**
 * {@link Enquete}のリポジトリ
 */
public interface IEnqueteRepository {
    /**
     * 全ての{@link Enquete}の{@link List}を返します
     * @return {@link Enquete}の{@link List}
     */
    List<Enquete> find();

    /**
     * Enqueteテーブルに{@link Enquete}を追加します
     * @param enquete 追加する{@link Enquete}
     * @return 追加行数
     */
    long insert(Enquete enquete);

    /**
     *
     * @param accountName
     * @return
     */
    List<Enquete> findBy(String accountName);

    /**
     *
     * @param respondentList
     * @return
     */
    List<Enquete> findBy(List<Respondent> respondentList);

    /**
     *
     * @param enquete
     */
    void update(Enquete enquete);
}
