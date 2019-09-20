package com.fit.cache;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-08-25
 */
public interface Cache {

    boolean set(String key, String value);

    String get(String key);
}
