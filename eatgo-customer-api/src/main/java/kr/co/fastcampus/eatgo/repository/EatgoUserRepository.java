package kr.co.fastcampus.eatgo.repository;


import kr.co.fastcampus.eatgo.domain.EatgoUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EatgoUserRepository extends CrudRepository<EatgoUser, Long> {
    Optional<EatgoUser> findByEmail(String email);
}
