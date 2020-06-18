package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantServiceTests {

    @Autowired
    RestaurantService restaurantService;

//    @Test
//    public void getReataurants() {
//        List<Restaurant> restaurants = restaurantService.getRestaurants();
//
//        restaurants.forEach(System.out::println);
//        assertEquals(restaurants.size(), 8);
//    }

    @Test
    public void getReataurant() {
        Restaurant restaurant = restaurantService.getRestaurant(2L);

        restaurant.getMenuItemList().forEach(System.out::println);

        assertEquals(restaurant.getName(), "BeRyong");
//        assertThrows(RestaurantNotFoundException.class, restaurant::toString);
    }

    @Test
    public void create() {
        Restaurant restaurant = Restaurant.builder()
                .name("BeRyong").address("Gu-Ro").build();

        restaurantService.create(restaurant);

    }

    @Test
    public void update() {

    }

}