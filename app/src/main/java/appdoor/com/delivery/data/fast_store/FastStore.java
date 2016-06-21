package appdoor.com.delivery.data.fast_store;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;

public class FastStore {

    private List<MenuItem> mMenu;
    private Map<Integer, List<FoodItem>> mFoods;

    public FastStore() {
        mFoods = new HashMap<>();
    }

    public List<MenuItem> getMenu() {
        return mMenu;
    }

    public void setMenu(List<MenuItem> menu) {
        mMenu = menu;
    }

    public List<FoodItem> getFoods(Integer categoryId) {
        return mFoods.get(categoryId);
    }

    public void setFoods(Integer categoryId, List<FoodItem> foods) {
        mFoods.put(categoryId, foods);
    }
}
