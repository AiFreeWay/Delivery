package appdoor.com.delivery.data.fast_store;


import java.util.List;

import appdoor.com.delivery.domain.models.MenuCategory;

public class FastStore {

    private List<MenuCategory> mFoodMenu;

    public List<MenuCategory> getFoodMenu() {
        return mFoodMenu;
    }

    public void setFoodMenu(List<MenuCategory> mFoodMenu) {
        this.mFoodMenu = mFoodMenu;
    }
}
