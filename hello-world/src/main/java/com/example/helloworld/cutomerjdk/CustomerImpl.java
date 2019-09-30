package com.example.helloworld.cutomerjdk;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/26 11:25
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public class CustomerImpl implements CustomerService{
    @Override
    public void gotohome() {
        System.out.println("回家去");
    }

    @Override
    public void gotowork() {
        System.out.println("去工作");
    }
}
