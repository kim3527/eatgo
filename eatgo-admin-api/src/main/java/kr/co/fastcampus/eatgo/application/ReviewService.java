package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.*;
import kr.co.fastcampus.eatgo.domain.Review;
import kr.co.fastcampus.eatgo.repository.RestaurantRepository;
import kr.co.fastcampus.eatgo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public void create(Long id, Review review) {

        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));

        review.setRestaurant(restaurant);
//        review.setRestaurantId(restaurant.getId());
        reviewRepository.save(review);
//

    }
}
