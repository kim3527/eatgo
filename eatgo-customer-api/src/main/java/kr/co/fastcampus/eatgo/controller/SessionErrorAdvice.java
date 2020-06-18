package kr.co.fastcampus.eatgo.controller;

import kr.co.fastcampus.eatgo.domain.EatgoUserNotFoundException;
import kr.co.fastcampus.eatgo.domain.EatgoUserPasswordInCorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SessionErrorAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EatgoUserPasswordInCorrectException.class)
    public String handlePasswordWrong() {
        return "{PasswordInCorredt}";

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EatgoUserNotFoundException.class)
    public String handleUserNotFound(){
        return "{UserNotFound}";
    }
}
