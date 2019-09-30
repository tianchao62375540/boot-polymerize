package com.tcboot.web;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>9�� 23, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    MockMvc mockMvc = null;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUsers()
     */
    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/getUsers")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    /**
     * Method: getUser(Long id)
     */
    @Test
    public void testGetUser() throws Exception {
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.post("/getUsers", 1)
                .accept(MediaType.APPLICATION_JSON_UTF8));
        perform.andDo(MockMvcResultHandlers.print());
    }

    /**
     * Method: save(User user)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: update(User user)
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(@PathVariable("id") Long id)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }


} 
