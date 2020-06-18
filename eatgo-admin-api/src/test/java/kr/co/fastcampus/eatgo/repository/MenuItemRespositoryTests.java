package kr.co.fastcampus.eatgo.repository;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuItemRespositoryTests {

    @Autowired
    private MenuItemRespository menuItemRespository;
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void findByRestaurant(){
        Optional<Restaurant> byId = restaurantRepository.findById(1L);

        byId.map(restaurant -> {
            List<MenuItem> byRestaurant = menuItemRespository.findByRestaurant(restaurant);

            for (MenuItem menuItem : byRestaurant){
                System.out.println(menuItem.toString());
            }

            return  byRestaurant;
        });
    }

}