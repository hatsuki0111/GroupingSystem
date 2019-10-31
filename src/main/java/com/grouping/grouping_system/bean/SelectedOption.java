package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 回答内容
 */
@AllArgsConstructor
@Data
public class SelectedOption {
    private String accountName;
    private long enqueteId;
    private String optionLabel;

    public SelectedOption() {
        this("", 0, "");
    }
}
