package kr.co.fastcampus.eatgo.domain;

public class EatgoUserPasswordInCorrectException extends RuntimeException {
    public EatgoUserPasswordInCorrectException(String password){
        super("Password InCorrect Exception :"+ password);
    }
}
