package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Enquete;

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
}
