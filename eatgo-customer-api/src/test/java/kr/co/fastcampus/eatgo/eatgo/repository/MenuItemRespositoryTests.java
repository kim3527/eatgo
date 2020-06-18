package kr.co.fastcampus.eatgo.eatgo.repository;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.repository.MenuItemRespository;
import kr.co.fastcampus.eatgo.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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