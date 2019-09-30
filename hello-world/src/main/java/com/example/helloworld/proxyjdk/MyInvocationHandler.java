package com.example.helloworld.proxyjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/24 09:08
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

    private Service target;
    public MyInvocationHandler(Service service) {
        this.target = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前。。。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("调用后。。。。。");
        return invoke;
    }
}
