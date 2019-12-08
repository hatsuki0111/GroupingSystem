package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 回答内容
 */
@AllArgsConstructor
@Data
public class SelectedOption implements Serializable {
    private String accountName;
    private long enqueteId;
    private String optionLabel;

    public SelectedOption() {
        this("", 0, "");
    }
}
