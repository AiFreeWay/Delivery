package appdoor.com.delivery.domain.interfaces;


import java.util.List;

import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.domain.models.Table;

public interface Repository {

    List<MenuItem> getMenu() throws Exception;
    List<FoodItem> getFoods(int categoryId) throws Exception;
    Table getTable(int orderTable) throws Exception;
    int getTableLocal() throws Exception;
    void postTable(Integer number) throws Exception;
}
