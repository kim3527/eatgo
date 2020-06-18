package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.EatgoUser;
import kr.co.fastcampus.eatgo.domain.EatgoUserNotFoundException;
import kr.co.fastcampus.eatgo.domain.EatgoUserPasswordInCorrectException;
import kr.co.fastcampus.eatgo.repository.EatgoUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EatgoUserService {

    @Autowired
    EatgoUserRepository eatgoUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public EatgoUser create(EatgoUser eatgoUser){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = eatgoUser.getPassword();

        eatgoUser.setPassword(passwordEncoder.encode(password));
        log.info("created Password :" +eatgoUser.getPassword());

        return eatgoUserRepository.save(eatgoUser);
    }

    public EatgoUser authenticate(String email, String password) {
        EatgoUser eatgoUser = eatgoUserRepository.findByEmail(email).orElseThrow(() -> new EatgoUserNotFoundException(email));

        log.info("rawPassword :" + password);
        log.info("saved password :" + eatgoUser.getPassword());

        if(!passwordEncoder.matches(password, eatgoUser.getPassword())){
            throw new EatgoUserPasswordInCorrectException(password);
        }

        return eatgoUser;



//        Optional<EatgoUser> byEmail = eatgoUserRepository.findByEmail(email);
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encPass = passwordEncoder.encode(password);
//
//        log.info("password : " +password + "|| encoded : " + encPass);
//
//
//
//
//        return byEmail.map(user -> {
//            if (user.getPassword().equals(encPass)){
//                log.info("DB password" + user.getPassword());
//                return true;
//            }
//
//            else {
//                log.info("DB password" + user.getPassword());
//                throw new EatgoUserPasswordInCorrectException(email);
//            }
//        }).orElseThrow(() -> new EatgoUserNotFoundException(email));

    }
}
