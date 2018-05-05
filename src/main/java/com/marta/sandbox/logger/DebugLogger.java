package com.marta.sandbox.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

public class DebugLogger implements Serializable {

    @AroundInvoke
    public Object printLog (InvocationContext ctx) throws Exception {
        System.out.println ("Called " +  ctx.getMethod().getName());
        return ctx.proceed();
    }

}
