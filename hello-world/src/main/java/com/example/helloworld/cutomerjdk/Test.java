package com.example.helloworld.cutomerjdk;

/**
 * Description:
 * <p>
 * ModelName:【】模块 Incompatible
 *
 * @author: TianChao
 * Create at:  2019/9/26 11:22
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        MyClassLoader myClassLoader = new MyClassLoader("F:\\ideaworkspace\\springboot\\bootpolymerize\\hello-world\\src\\main\\java\\com\\example\\helloworld", "com.example.helloworld");
        CustomerImpl customer = new CustomerImpl();
        Object o = MyProxy.newProxyInstance(myClassLoader, customer.getClass().getInterfaces(), new CustomerInvocationHandler(customer));
        ((CustomerService)o).gotohome();
    }
}
