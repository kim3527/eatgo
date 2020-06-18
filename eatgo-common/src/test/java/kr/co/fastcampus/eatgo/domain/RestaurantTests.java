package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest(classes = Restaurant.class)
class RestaurantTests {

    @Test
    public void create(){
        Restaurant restaurant = Restaurant.builder().name("Bob zip").build();
        Assertions.assertEquals("Bob zip", restaurant.getName());
    }

    @Test
    public void information(){
        Restaurant restaurant = Restaurant.builder().name("Bob zip").address("Seoul").build();
        Assertions.assertEquals("Seoul", restaurant.getAddress());
    }
}