package appdoor.com.delivery.data.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import appdoor.com.delivery.data.fast_store.FastStore;
import appdoor.com.delivery.data.mock_store.MockStore;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.MenuCategory;

@Singleton
public class RepositoryImpl implements Repository {

    private MockStore mMockStore;
    private FastStore mFastStore;

    @Inject
    public RepositoryImpl() {
        mMockStore = new MockStore();
        mFastStore = new FastStore();
    }

    @Override
    public List<MenuCategory> getFoodMenu() throws Exception {
        List<MenuCategory> foodMenu = mFastStore.getFoodMenu();
        if (foodMenu == null) {
            foodMenu = mMockStore.getFoodMenu();
            mFastStore.setFoodMenu(foodMenu);
        }
        return foodMenu;
    }
}
