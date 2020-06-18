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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReviewControllerTests {

    @Autowired
    private ReviewController reviewController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(reviewController).build();
    }


    @Test
    public void create() throws Exception {

        mockMvc.perform(post("/restaurants/3/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"writer\":\"uck\", \"score\":3,\"comment\":\"Bad\"}"))
                .andDo(print())
                .andExpect(status().isCreated());


    }



}