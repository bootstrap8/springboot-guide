package com.fit.common.chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-29
 */
public class CommondChain extends ChainBase {

    public CommondChain() {
        super();
        addCommand(new GetUserInfo());
        addCommand(new TestDriver());
        addCommand(new NegotiateSale());
        addCommand(new ArrangeFinancing());
        addCommand(new CloseSale());
    }

    public static void main(String[] args) {
        CommondChain commondChain = new CommondChain();
        Context context = new ContextBase();

        try {
            boolean result = commondChain.execute(context);
            System.out.println("-->" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
