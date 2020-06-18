package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.application.EatgoUserService;
import kr.co.fastcampus.eatgo.domain.EatgoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class EatgoUserController {

    //1. EatgoUser List
    //2. EatgoUser Create
    //3. EatgoUser update
    //4. EatgoUser delete -> level =0;
    //1:Customer, 2:

    @Autowired
    EatgoUserService eatgoUserService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EatgoUser user) throws URISyntaxException {

        EatgoUser eatgoUser = eatgoUserService.create(user);


        URI uri = new URI("/user/" );

        return ResponseEntity.created(uri).body("{}");
    }

    @GetMapping
    public List<EatgoUser> list(){
        return eatgoUserService.getUsers();

    }

    @PatchMapping("/{id}")
    public EatgoUser update(@PathVariable Long id, @RequestBody EatgoUser eatgoUser){

        return eatgoUserService.update(id, eatgoUser);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        eatgoUserService.delete(id);
    }
}
