package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.EatgoUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import utils.JsonWebTokenUtil;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SessionControllerTests {

    @Autowired
    private SessionController sessionController;

    @Autowired
    private EatgoUserService eatgoUserService;

    @Autowired
    private JsonWebTokenUtil jsonWebTokenUtil;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(sessionController).build();

    }


    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/session")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"andy@nate.com\",\"password\":\"godnr\"}"))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().string(containsString(".")));

//        verify(eatgoUserService).authenticate(eq("kim3527@nate.com"), eq("test"));
    }


}