package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Option;

import java.util.List;

/**
 * {@link Option}のリポジトリ
 */
public interface IOptionRepository {
    /**
     * 全ての{@link Option}の{@link List}を返します
     * @return {@link Option}の{@link List}
     */
    List<Option> find();
}
