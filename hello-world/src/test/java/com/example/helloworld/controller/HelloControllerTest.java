package com.example.helloworld.controller;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * HelloController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>9�� 23, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloControllerTest {

    private MockMvc mvc;
    @Before
    public void before() throws Exception {
        mvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @After
    public void after() throws Exception {

    }

    /**
     * Method: hello()
     */
    @Test
    public void testHello() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("result:"+new String(mvcResult.getResponse().getContentAsByteArray()));
    }


}
