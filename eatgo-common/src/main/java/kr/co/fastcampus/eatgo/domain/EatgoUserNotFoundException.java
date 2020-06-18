package kr.co.fastcampus.eatgo.domain;

public class EatgoUserNotFoundException extends RuntimeException{
    public EatgoUserNotFoundException(String email) {
        super("could Not Found User : " + email);
    }
}
