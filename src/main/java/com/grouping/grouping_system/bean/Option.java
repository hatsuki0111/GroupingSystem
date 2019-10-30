package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 選択肢
 */
@AllArgsConstructor
@Data
public class Option {
    private long enqueteId;
    private String label;
    private boolean authorized;     // 承認されたかどうか
}
