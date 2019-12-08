package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 選択肢
 */
@AllArgsConstructor
@Data
public class Option implements Serializable {
    private long enqueteId;
    private String label;
    private boolean authorized;     // 承認されたかどうか

    public Option(){
        this(0,"",false);
    }
}
