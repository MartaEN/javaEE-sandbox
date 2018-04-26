package com.marta.sandbox.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class DebugLogger {

    @AroundInvoke
    public Object printLog (InvocationContext ctx) throws Exception {
        System.out.println ("Called " +  ctx.getMethod().getName());
        return ctx.proceed();
    }

}
