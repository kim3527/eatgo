package kr.co.fastcampus.eatgo.repository;

import kr.co.fastcampus.eatgo.domain.EatgoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EatgoUserRepository extends CrudRepository<EatgoUser, Long> {

    List<EatgoUser> findAll();

}
