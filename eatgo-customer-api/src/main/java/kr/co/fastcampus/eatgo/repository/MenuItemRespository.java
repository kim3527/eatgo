package kr.co.fastcampus.eatgo.repository;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRespository extends JpaRepository<MenuItem, Long> {
//    List<MenuItem> findAllByMenuItemRestaurantId(Long id);

//    void deleteById(Long id);

//    List<MenuItem> findAllByRestaurant(Restaurant restaurant);

    List<MenuItem> findByRestaurant(Restaurant restaurant);
}
