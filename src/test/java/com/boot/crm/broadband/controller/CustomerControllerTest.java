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

import java.nio.charset.Charset;

/**
 * @author Hogan_Lee
 * @create 2019-12-02 13:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void findAll() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/customer")
                .param("major", "电子")
                .contentType(MediaType.APPLICATION_JSON)).
                andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);
    }


    @Test
    public void deleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/" + 14)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findOneSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/" + 15)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);
    }

    @Test
    public void addOneSuccess() throws Exception {
        String content = "{\"cust_name\":\"小明\",\"cust_major\":\"电子商务\",\"cust_level\":\"包年\",\"cust_create_id\":2,\"cust_linkman\":\"小雪\",\"cust_phone\":\"010-88888887\",\"cust_mobile\":\"13888888888\",\"cust_zipcode\":\"100096\",\"cust_address\":\"北京昌平区西三旗\",\"cust_createtime\":\"2016-04-08T16:32:01.000+0000\"}";
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);
    }

    @Test
    public void testUpdateSuccess() throws Exception {
        String content = "{}";
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/customer/" + 15)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(result);


    }
}