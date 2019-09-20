package com.fit.bean;

import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private String columns;
    private List<String> names;
}
