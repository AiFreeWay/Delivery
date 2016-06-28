package appdoor.com.delivery.domain.interfaces;


import java.util.List;

import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;

public interface Repository {

    List<MenuItemDomain> getMenu() throws Exception;
    List<FoodItemDomain> getFoods(int categoryId) throws Exception;
    TableDomain getTable(int orderTable) throws Exception;
    TableDomain getTableLocal() throws Exception;
    void postTable(TableDomain tableDomain) throws Exception;
    void putTableLocal(TableDomain table) throws Exception;
    void addOrderedtoCart(OrderedFoodDomain food) throws Exception;
    void cacheMenu(List<MenuItemDomain> menu) throws Exception;
    void cacheFoods(List<FoodItemDomain> foods) throws Exception;
    List<OrderedFoodDomain> getOrderedFoods() throws Exception;
    void exit() throws Exception;
}
