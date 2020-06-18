package kr.co.fastcampus.eatgo.eatgo.controller;

import kr.co.fastcampus.eatgo.controller.RestaurantController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class RestaurantControllerTests {

    @Autowired
    RestaurantController restaurantController;



    private MockMvc mockMvc;

    //가짜 객체
    //실제 restaurant service 를 사용하지 않고 테스트 하기 위해 MockBean 으로 설정함.
    //실제 동작과 분리 하여 restaurantController 를 테스트 하기 위해 사용.
//    @MockBean
//    private RestaurantService restaurantService;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }


//    @Test
//    public void list() throws Exception {
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().string(containsString("\"id\":1")))
//                .andExpect(content().string(containsString("\"name\":\"COCOS\"")));
//    }
//
//    @Test
//    public void detail() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/1"))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(content().string(containsString("\"id\":1")))
////                .andExpect(content().string(containsString("Kimchi")))
//                .andExpect(content().string(containsString("\"name\":\"COCOS\"")));
//
//    }

//    @Test
//    public void detailWithNoData() throws Exception {
//
//        mockMvc.perform(get("/restaurants/1000"))
//                .andExpect(status().isNotFound());
////                .andExpect(content().string("{}"));
//    }
    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Beryong\",\"address\":\"Seoul\"}"))
                .andExpect(status().isCreated())
//                .andExpect(header().string("location","/restaurants/1004"))
                .andExpect(content().string("{}"));
    }

    @Test
    public void createWithInvalidData() throws Exception {
        mockMvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"\"}"))
                .andExpect(status().isBadRequest());
    }


//    @Test
//    public void update() throws Exception {
//        mockMvc.perform(patch("/restaurants/3")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"COCOS2\",\"address\":\"Seoul\"}"))
//                .andExpect(status().isOk());
//
//    }


}