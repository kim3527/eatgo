package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @PostMapping("/restaurants/{id}/reviews")
    public ResponseEntity<?> create(@PathVariable Long id, @Valid @RequestBody Review review) throws URISyntaxException {

        reviewService.create(id, review);

        return ResponseEntity.created(new URI("/restaurants/" + id +"/reviews")).body("{}");
    }




}
