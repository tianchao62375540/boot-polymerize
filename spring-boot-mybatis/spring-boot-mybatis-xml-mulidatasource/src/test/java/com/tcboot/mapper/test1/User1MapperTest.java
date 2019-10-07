package com.tcboot.mapper.test1;

import com.tcboot.mapper.test2.User2Mapper;
import com.tcboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/7 08:50
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class User1MapperTest {
    @Autowired
    @Qualifier("test1DataSource")
    private DataSource dataSource;

    @Autowired
    User1Mapper user1Mapper;

    @Autowired
    User2Mapper user2Mapper;
    @Test
    public void teUserMapper1(){
        List<User> all = user1Mapper.getAll();
        all.stream().forEach(System.out::println);
        System.out.println("================================");
        List<User> all1 = user2Mapper.getAll();
        all1.stream().forEach(System.out::println);
    }
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() {

    }

    @Test
    public void getOne() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}