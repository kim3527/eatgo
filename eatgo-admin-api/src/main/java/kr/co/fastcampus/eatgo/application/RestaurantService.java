package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.*;
import kr.co.fastcampus.eatgo.repository.MenuItemRespository;
import kr.co.fastcampus.eatgo.repository.RestaurantRepository;
import kr.co.fastcampus.eatgo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRespository menuItemRespository;

    @Autowired
    ReviewRepository reviewRepository;


    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant;
    }

    public List<Restaurant> getRestaurants(String region, Long id) {
        return restaurantRepository.findAllByAddressContainingAndCategoryId(region, id);
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant update(Long id, Restaurant restaurant) {
        Optional<Restaurant> byId = restaurantRepository.findById(id);

        return byId.map(restaurant1 -> {
            restaurant1.setName(restaurant.getName())

                    .setAddress(restaurant.getAddress());

            return restaurantRepository.save(restaurant1);

        }).orElse(null);
    }
}
