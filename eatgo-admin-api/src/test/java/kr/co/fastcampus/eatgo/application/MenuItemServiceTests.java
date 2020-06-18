package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MenuItemServiceTests {

    @Autowired
    MenuItemService menuItemService;

    @Test
    public void bulkUpdate(){
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(MenuItem.builder().name("Ramen").build());
        menuItemList.add(MenuItem.builder().name("Beef").build());

        menuItemService.bulkUpdate(3L, menuItemList);



    }


}