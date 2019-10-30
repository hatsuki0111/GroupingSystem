package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * アンケートと回答者のリレーション
 */
@AllArgsConstructor
@Data
public class Respondent {
    private long enqueteId;
    private String accountName;
}
