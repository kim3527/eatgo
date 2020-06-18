package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.DTO.SessionRequestDTO;
import kr.co.fastcampus.eatgo.DTO.SessionResponseDTO;
import kr.co.fastcampus.eatgo.application.EatgoUserService;
import kr.co.fastcampus.eatgo.domain.EatgoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.JsonWebTokenUtil;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private EatgoUserService eatgoUserService;

    @Autowired
    private JsonWebTokenUtil jsonWebTokenUtil;

    @PostMapping("")
    public ResponseEntity<SessionResponseDTO> create(@RequestBody SessionRequestDTO requestDTO) throws URISyntaxException {
        String url  ="/session";

        EatgoUser authenticate = eatgoUserService.authenticate(requestDTO.getEmail(), requestDTO.getPassword());


        String token = jsonWebTokenUtil.createToken(authenticate.getEmail());

        SessionResponseDTO session = SessionResponseDTO.builder().accessToken(token).build();
        return ResponseEntity.created(new URI(url)).body(session);
    }
}
