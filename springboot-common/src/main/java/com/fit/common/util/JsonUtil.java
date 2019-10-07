package com.fit.common.util;

import com.alibaba.fastjson.JSON;

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

}
