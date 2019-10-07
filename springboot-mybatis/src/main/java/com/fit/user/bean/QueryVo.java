package com.fit.user.bean;

import com.fit.common.util.JsonUtil;
import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private String columns;
    private List<String> names;

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(new QueryVo()));
    }
}
