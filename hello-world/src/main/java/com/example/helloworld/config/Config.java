package com.example.helloworld.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.DigestException;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/9/29 08:52
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class Config {

    @Bean(value="u")
    //@ConfigurationProperties(prefix = "customer.user")

    public User user(UserProperties userProperties){
        System.out.println(userProperties.getName());
        return new User().setName(userProperties.name);
    }
    @Bean
    public User user1(UserProperties userProperties){
        System.out.println(userProperties.getName());
        return new User().setName("自定义");
    }

    @Bean(value = "dog1")
    public Dog dog(@Qualifier("u") User user){
        return new Dog().setDogname("gou").setUser(user);
    }

    @Bean(value = "dog2")
    public Dog dog1(@Qualifier("user1") User user){
        return new Dog().setDogname("gou").setUser(user);
    }
}
