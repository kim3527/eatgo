package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.EatgoUser;
import kr.co.fastcampus.eatgo.domain.EatgoUserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EatgoUserServiceTests {

    @Autowired
    EatgoUserService eatgoUserService;
    @Test
    public void create(){

        EatgoUser user = EatgoUser.builder().email("kim5085@nate.com")
                .level(10L).name("Andy").password("rlagodnr").build();

        EatgoUser eatgoUser = eatgoUserService.create(user);
        assertEquals(eatgoUser.getName(), "Andy");


    }


    @Test
    public void authenticateWithNotExistedEmail(){



        String email = "a@nate.com";

        eatgoUserService.authenticate(email, "x");

        assertThrows(EatgoUserNotFoundException.class, () -> {});


    }
//    ""

//    {"applicationId":"sdsdf", "applicationName":"dfsdfs"}

}