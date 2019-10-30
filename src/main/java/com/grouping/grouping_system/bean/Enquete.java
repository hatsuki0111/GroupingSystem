package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

/**
 * アンケート
 */
@AllArgsConstructor
@Data
public class Enquete {
    private long id;
    private String title;
    private String authorAccountName;   // アンケート作成者の名前
    private Timestamp start;    // 回答受け付け開始時間
    private Timestamp end;      // 回答受け付け終了時間
}
