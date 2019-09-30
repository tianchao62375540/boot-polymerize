package com.example.helloworld;

import com.example.helloworld.config.Dog;
import com.example.helloworld.config.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests implements ApplicationContextAware,InitializingBean {
	@PostConstruct
	public void init(){
		System.out.println("@postConstruct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Autowired
	@Qualifier("u")
	User user;
	@Autowired
	@Qualifier("user1")
	User user1;

	@Test
	public void contextLoads() {
		System.out.println("hello world！");
	}

	@Test
	public  void  test(){
		System.out.println(user);
		System.out.println("=====");
		Map<String, Dog> beansOfType = applicationContext.getBeansOfType(Dog.class);
		for(String s : beansOfType.keySet()){
			System.out.println(s+"  "+beansOfType.get(s));
		}
	}

}
