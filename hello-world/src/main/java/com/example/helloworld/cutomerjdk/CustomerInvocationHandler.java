package com.example.helloworld.cutomerjdk;

import com.example.helloworld.proxyjdk.Service;
import com.example.helloworld.proxyjdk.ServiceTarget;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/26 09:04
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class CustomerInvocationHandler implements InvocationHandlerInterface{

    private CustomerService target;
    public CustomerInvocationHandler(CustomerService service) {
        this.target = service;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自定义动态代理方法前");
        Object result = method.invoke(target, args);
        System.out.println("自定义动态代理方法后");
        return result;
    }
}
