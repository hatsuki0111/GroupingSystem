package com.grouping.grouping_system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * アンケート
 */
@AllArgsConstructor
@Data
public class Enquete implements Serializable {
    private long id;
    private String title;
    private String authorAccountName;   // アンケート作成者の名前
    private LocalDateTime startDateTime;    // 回答受け付け開始時間
    private LocalDateTime endDateTime;      // 回答受け付け終了時間
    private LocalDateTime postedDateTime;  //投稿時刻

    public Enquete() {
        this(0, "", "", LocalDateTime.now(), LocalDateTime.now(),LocalDateTime.now());
    }
}
