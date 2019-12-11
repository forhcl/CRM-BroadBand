package com.boot.crm.broadband.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * @author Hogan_Lee
 * @create 2019-12-04 17:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findCustomer() {
    }

    @Test
    public void addOne() throws Exception {


            String content = "{\"username\":\"dshd\",\"password\":\"12\",\"phone\":\"15016551487\",\"address\":\"广州\",\"email\":\"15016551487@163.com\"}";
            String result=mockMvc.perform(MockMvcRequestBuilders.post("/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);


    }

    @Test
    public void deleteSuccess() throws Exception {
        String result=mockMvc.perform(MockMvcRequestBuilders.post("/user/batchdelete")
                .content("{\"ids\":\"[26,27]\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);
    }

    @Test
    public void testUpdateSuccess() throws Exception {
        String content = "{\"user\":\"123\"}";
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/" + 18)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);
    }

    @Test
    public void enableStateSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/user/"+11));
    }
}