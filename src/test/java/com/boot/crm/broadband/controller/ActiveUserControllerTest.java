package com.boot.crm.broadband.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Hogan_Lee
 * @create 2019-12-06 10:58
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActiveUserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void updateActiveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/active_user.message")
        .contentType(MediaType.APPLICATION_JSON).content("{\"address\":\"fffj\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}