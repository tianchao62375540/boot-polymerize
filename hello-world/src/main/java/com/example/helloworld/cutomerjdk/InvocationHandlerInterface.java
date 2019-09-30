package com.example.helloworld.cutomerjdk;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/26 08:58
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public interface InvocationHandlerInterface {
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
