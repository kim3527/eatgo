package utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;

@Component
public class JsonWebTokenUtil {
    public String createToken(String name) {

        Key key = Keys.hmacShaKeyFor("12345678901234567890123456789012".getBytes());

        return Jwts.builder()
                .claim("username", name)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

//    public static void main(String[] args) {
//        JsonWebTokenUtil jwt = new JsonWebTokenUtil();
//
//        System.out.println(jwt.createToken("John"));
//
//    }
}
