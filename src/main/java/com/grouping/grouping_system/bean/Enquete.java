package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    public Enquete(){
        this(0,"","", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
    }
}
