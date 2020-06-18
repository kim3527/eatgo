package kr.co.fastcampus.eatgo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class EatgoUserControllerTests {

    @Autowired
    private EatgoUserController eatgoUserController;


    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(eatgoUserController).build();
    }

    @Test
    public void create() throws Exception {
//        EatgoUser eatgoUser = EatgoUser.builder().email("kim3527@nate.com").level(10).name("관리자").build();


        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"욱\",\"email\":\"kim3527@nate.com\",\"level\":10}"))
                .andExpect(status().isCreated());

    }

    @Test
    public void list() throws Exception {

//        given()
//
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(print())

                .andExpect(status().isOk());
    }
    @Test
    public void upate() throws Exception {
                mockMvc.perform(patch("/users/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"email\":\"kim3527@nate.com\",\"name\":\"해욱\",\"level\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1"))

                .andExpect(status().isOk());
    }


}