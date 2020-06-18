package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.EatgoUser;
import kr.co.fastcampus.eatgo.repository.EatgoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EatgoUserService {

    @Autowired
    EatgoUserRepository eatgoUserRepository;


    public EatgoUser create(EatgoUser user) {
        EatgoUser eatgoUser = eatgoUserRepository.save(user);

        return eatgoUser;

    }

    public List<EatgoUser> getUsers() {

        return eatgoUserRepository.findAll();

    }

    public EatgoUser update(Long id, EatgoUser eatgoUser) {
        Optional<EatgoUser> byId = eatgoUserRepository.findById(id);

        return byId.map(getUser -> {
            getUser.setEmail(eatgoUser.getEmail());
            getUser.setLevel(eatgoUser.getLevel());
            getUser.setName(eatgoUser.getName());

            return getUser;

        }).map(upateUser -> eatgoUserRepository.save(upateUser))
                .orElse(null);
    }

    public EatgoUser delete(Long id) {
        Optional<EatgoUser> byId = eatgoUserRepository.findById(id);

        return byId.map(getUser ->{
            getUser.setLevel(0L);

            eatgoUserRepository.save(getUser);
            return  getUser;
        }).orElse(null);

    }
}
