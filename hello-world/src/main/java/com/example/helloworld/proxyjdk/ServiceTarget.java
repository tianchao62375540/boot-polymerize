package com.example.helloworld.proxyjdk;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/24 08:53
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class ServiceTarget implements Service ,ExtService{
    @Override
    public void insert(User user) {
        System.out.println("目标方法添加用户"+user);
    }

    @Override
    public String getExt() {
        return "==ext==";
    }

    @Override
    public User getUser(Integer id) {
        System.out.println("目标方法获取用户id:"+id);
        new User().setId(1);
        return new User().setId(id).setName("tc"+id+"号");
    }
}
