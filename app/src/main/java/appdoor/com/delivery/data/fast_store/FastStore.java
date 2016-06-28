package appdoor.com.delivery.data.fast_store;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;

public class FastStore {

    private List<OrderedFoodDomain> mOrderedFoods;

    public FastStore() {
        mOrderedFoods = new LinkedList<OrderedFoodDomain>();
    }

    public List<OrderedFoodDomain> getOrderedFoods() {
        return mOrderedFoods;
    }

    public void setOrderedFoods(List<OrderedFoodDomain> orderedFoods) {
        mOrderedFoods = orderedFoods;
    }

    public void addOrderedFood(OrderedFoodDomain orderedFood) {
        mOrderedFoods.add(orderedFood);
    }
}
