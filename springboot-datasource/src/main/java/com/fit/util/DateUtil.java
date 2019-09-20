package com.fit.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Stone
 * @version 1.0
 * @since 2019-09-16
 */
public class DateUtil {

    //yyyy-MM-dd HH:mm:ss
    private static ThreadLocal<DateFormat> formater = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static String format(Date date) {
        return formater.get().format(date);
    }

}
