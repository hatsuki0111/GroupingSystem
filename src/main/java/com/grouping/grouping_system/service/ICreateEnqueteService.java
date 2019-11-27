package com.grouping.grouping_system.service;

import com.grouping.grouping_system.bean.Account;
import com.grouping.grouping_system.bean.Enquete;

import java.util.List;

public interface ICreateEnqueteService { /**
     *
     * @return 全ての{@link Account}のリスト
     */
    List<Account> getAccountList();

    /**
     * enqueteテーブルに{@link Enquete}を追加します
     * @param enquete 追加する{@link Enquete}
     * @return 追加件数
     */
    int registerEnquete(Enquete enquete);
}
