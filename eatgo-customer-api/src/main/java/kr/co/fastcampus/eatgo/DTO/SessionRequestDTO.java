package kr.co.fastcampus.eatgo.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class SessionRequestDTO {
    private String email;
    private String password;
}
