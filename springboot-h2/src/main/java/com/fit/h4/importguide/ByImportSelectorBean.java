package com.fit.h4.importguide;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-23
 */
public class ByImportSelectorBean {

    @Autowired
    private Account account;

    @PostConstruct
    public void setUp() {
        System.out.println("ByImportSelectorBean setUp, account=" + account);
    }

}
