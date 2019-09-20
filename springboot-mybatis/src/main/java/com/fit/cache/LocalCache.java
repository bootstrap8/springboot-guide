package com.fit.cache;

import org.springframework.stereotype.Component;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2019-08-25
 */
@Component("localCache")
public class LocalCache implements Cache {
    @Override
    public boolean set(String key, String value) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }
}
