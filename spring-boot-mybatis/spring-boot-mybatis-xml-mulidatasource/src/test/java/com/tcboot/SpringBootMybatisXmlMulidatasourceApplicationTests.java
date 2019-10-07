package com.tcboot;

import com.tcboot.mapper.test1.User1Mapper;
import com.tcboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisXmlMulidatasourceApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    User1Mapper user1Mapper;
    @Test
    public void contextLoads() {
        System.out.println(dataSource);
    }
    @Test
    public void teUserMapper1(){
        List<User> all = user1Mapper.getAll();
        all.stream().forEach(System.out::println);
    }

}
