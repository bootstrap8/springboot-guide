package com.fit.common.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-29
 */
//获取客户信息
public class GetUserInfo implements Command {
    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Get user info begin");
        context.put("userName", "Tom");
        return false;
    }
}
