package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Option;
import com.grouping.grouping_system.bean.SelectedOption;

import java.util.List;

/**
 * {@link SelectedOption}のリポジトリ
 */
public interface ISelectedOptionRepository {
    /**
     * 全ての{@link SelectedOption}の{@link List}を返します
     * @return {@link SelectedOption}の{@link List}
     */
    List<SelectedOption> find();

    /**
     *
     * @param selectedOption
     */
    void insert(SelectedOption selectedOption);

    List<SelectedOption> findBy(Option option, long enqueteId);
}
