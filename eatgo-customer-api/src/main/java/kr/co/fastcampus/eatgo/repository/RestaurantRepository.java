package kr.co.fastcampus.eatgo.repository;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();
//
//    Optional<Restaurant> findById(Long id);

//    Restaurant addRestaurant(Restaurant restaurant);
}
