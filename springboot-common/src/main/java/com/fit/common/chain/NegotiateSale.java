package com.fit.common.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-29
 */
//谈判
public class NegotiateSale implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("This is Negotiate");
        return false;
    }
}
