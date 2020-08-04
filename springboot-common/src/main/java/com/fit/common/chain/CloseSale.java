package com.fit.common.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-29
 */
//交付
public class CloseSale implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Thanks," + context.get("userName") + ",enjoying your driving");
        return false;
    }
}
