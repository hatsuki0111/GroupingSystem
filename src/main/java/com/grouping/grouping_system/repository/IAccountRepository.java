package com.grouping.grouping_system.repository;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.AccountNameCheck;

import java.util.List;

/**
 * {@link Account}のリポジトリ
 */
public interface IAccountRepository {
    /**
     * 全ての{@link Account}の{@link List}を返します
     * @return {@link Account}の{@link List}
     */
    List<Account> find();

    /**
     *
     * @return AccountNameCheck
     */
    List<AccountNameCheck> findName();
}
