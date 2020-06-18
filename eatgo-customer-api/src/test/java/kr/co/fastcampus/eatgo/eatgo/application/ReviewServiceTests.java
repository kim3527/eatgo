package kr.co.fastcampus.eatgo.eatgo.application;

import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.Review;
import kr.co.fastcampus.eatgo.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ReviewServiceTests {

    @Autowired
    ReviewService reviewService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void create() {

        Long restaurantId = 1L;

        Optional<Restaurant> byId = restaurantRepository.findById(restaurantId);

        byId.map(restaurant -> {
            Review review = Review.builder().comment("taste").score(5)
                    .writer("Kim")
                    .restaurant(restaurant)
                    .build();
            return review;
        }).map(review -> {
            reviewService.create(review.getRestaurant().getId(), review);
            return review;
//        }).orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
        }).orElse(null);


    }
}