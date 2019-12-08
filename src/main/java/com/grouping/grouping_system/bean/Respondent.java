package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * アンケートと回答者のリレーション
 */
@AllArgsConstructor
@Data
public class Respondent implements Serializable {
    private long enqueteId;
    private String accountName;

    public Respondent() {
        this(0, "");
    }
}
