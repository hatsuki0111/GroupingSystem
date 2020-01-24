package com.grouping.grouping_system.bean.evaluation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EvaluationItem implements Serializable {
    private long id;
    private String name;

    public EvaluationItem(){
        this(0,"");
    }
}
