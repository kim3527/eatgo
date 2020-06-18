package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.MenuItemService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController{

    @Autowired
    MenuItemService menuItemService;

    @PatchMapping("/restaurants/{id}/menuitems")
    public void menuUpdate(@PathVariable Long id, @RequestBody List<MenuItem> menuItemList){
        menuItemService.bulkUpdate(id, menuItemList);
    }

}
