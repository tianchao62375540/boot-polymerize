package com.tcboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
@MapperScan("com.tcboot.mapper")
@SpringBootApplication
public class SpringBootMybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisXmlApplication.class, args);
    }

}
