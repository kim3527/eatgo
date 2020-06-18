package kr.co.fastcampus.eatgo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EatgoUserControllerTests {

    //email,name, passworld
    //201
    @Autowired
    EatgoUserController eatgoUserController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(eatgoUserController).build();
    }


    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"Lau\", \"email\":\"kim3527@nate.com\",\"level\":10,\"password\":\"godnr2\"}"))
            .andExpect(status().isCreated());
    }
}