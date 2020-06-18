package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.*;
import kr.co.fastcampus.eatgo.repository.MenuItemRespository;
import kr.co.fastcampus.eatgo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRespository menuItemRespository;

    @Autowired
    RestaurantRepository restaurantRepository;


    public void bulkUpdate(Long id, List<MenuItem> menuItemList) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id));

        for (MenuItem menuItem : menuItemList) {

            menuItem.setRestaurant(restaurant);

            update(restaurant, menuItem);
        }
    }

    private void update(Restaurant restaurant, MenuItem menuItem) {
        if (menuItem.isDestroy()) {
            menuItemRespository.deleteById(menuItem.getId());
            return;
        }
//        menuItem.setMenuItemRestaurantId(restaurant.getId());
        menuItemRespository.save(menuItem);
    }
}
