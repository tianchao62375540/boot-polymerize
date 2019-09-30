package com.example.helloworld.proxyjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/24 09:09
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ServiceTarget target = new ServiceTarget();
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new MyInvocationHandler(target);
        Service proxy = (Service)Proxy.newProxyInstance(loader, interfaces, h);
        User user = proxy.getUser(14);
        System.out.println("main:"+user);
        ExtService proxy2 = (ExtService)Proxy.newProxyInstance(loader, interfaces, h);
        String ext = proxy2.getExt();
        System.out.println("ext:"+ext);

        Class[] classes = {ExtService.class};
        System.out.println(classes);
        System.out.println(classes.clone());

    }
}
