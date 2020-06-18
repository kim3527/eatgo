package utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JsonWebTokenUtil.class)
class JsonWebTokenUtilTests {

    @Test
    public void createToken(){
        JsonWebTokenUtil jsonWebTokenUtil = new JsonWebTokenUtil();
        String token = jsonWebTokenUtil.createToken("John");
        System.out.println(token);
        assertTrue(containsString(".").matches(token));


    }
}