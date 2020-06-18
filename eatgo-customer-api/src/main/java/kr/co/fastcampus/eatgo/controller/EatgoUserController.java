package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.EatgoUserService;
import kr.co.fastcampus.eatgo.domain.EatgoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/users")
public class EatgoUserController {

    @Autowired
    EatgoUserService eatgoUserService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody EatgoUser eatgoUser) throws URISyntaxException {

        EatgoUser user = eatgoUserService.create(eatgoUser);

        return ResponseEntity.created(new URI("/users" )).body("{}");
    }

}
