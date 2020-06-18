package kr.co.fastcampus.eatgo.eatgo.controller;

import kr.co.fastcampus.eatgo.controller.MenuItemController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MenuItemControllerTests {

    @Autowired
    private MenuItemController menuItemController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(menuItemController).build();
    }

    @Test
    public void bulkUpdate() throws Exception {
        mockMvc.perform(patch("/restaurants/2/menuitems")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"name\":\"Kimchi\"}]"))
                .andExpect(status().isOk());
    }
}