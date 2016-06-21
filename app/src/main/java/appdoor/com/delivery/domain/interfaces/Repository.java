package appdoor.com.delivery.domain.interfaces;


import java.util.List;

import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;

public interface Repository {

    List<MenuItem> getMenu() throws Exception;
    List<FoodItem> getFoods(int categoryId) throws Exception;
}
