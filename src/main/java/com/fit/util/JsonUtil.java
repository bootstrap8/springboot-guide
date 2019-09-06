package com.fit.util;

import com.alibaba.fastjson.JSON;
import com.fit.bean.QueryVo;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * json工具
 */
public class JsonUtil {

    /**
     * 对象转Json
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        return JSON.toJSONString(o);
    }

    public static void main(String[] args) {
        QueryVo queryVo = new QueryVo();
        queryVo.setColumns("id,name,age");
        List<String> names = Lists.newArrayList();
        names.add("Jack");
        names.add("Mark");
        queryVo.setNames(names);
        System.out.println(queryVo);
        System.out.println(toJson(queryVo));
    }
}
