package appdoor.com.delivery.data.repositories;

import android.util.Log;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import appdoor.com.delivery.data.fast_store.FastStore;
import appdoor.com.delivery.data.mock_store.MockStore;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;

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
    public List<MenuItem> getMenu() throws Exception {
        List<MenuItem> foodMenu = mFastStore.getMenu();
        if (foodMenu == null) {
            foodMenu = mMockStore.getMenu();
            mFastStore.setMenu(foodMenu);
        }
        return foodMenu;
    }

    @Override
    public List<FoodItem> getFoods(int categoryId) throws Exception {
        return mMockStore.getFoods();
    }
}
