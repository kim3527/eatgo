package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("")
    public List<Restaurant> list(){
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant detail(@PathVariable Long id){
        return restaurantService.getRestaurant(id);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant restaurant) throws URISyntaxException {

        restaurantService.create(restaurant);

        URI location = new URI("/restaurants/" + restaurant.getId());

        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/{id}")
    public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurant){
        System.out.println(restaurant.toString());
        return  restaurantService.update(id, restaurant);
    }
}
