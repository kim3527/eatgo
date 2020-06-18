package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.EatgoUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EatgoUserServiceTests {

    @Autowired
    EatgoUserService eatgoUserService;

//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(eatgoUserService).build();
//    }


    @Test
    public void update() throws Exception {
        EatgoUser eatgoUser = EatgoUser.builder().name("욱").email("kim3527@naver.com").level(1L).build();
        EatgoUser updateEatgoUser =  eatgoUserService.update(1L, eatgoUser);
        assertEquals(updateEatgoUser.getName(), "욱");
    }

    @Test
    public void delete(){
        EatgoUser delete = eatgoUserService.delete(1L);

        assertEquals(delete.getLevel(), 0L);


    }
}