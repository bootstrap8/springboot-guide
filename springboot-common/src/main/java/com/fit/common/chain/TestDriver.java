package com.fit.common.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-29
 */
//预约试驾
public class TestDriver implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Test driver begin....");
        return false;
    }
}
