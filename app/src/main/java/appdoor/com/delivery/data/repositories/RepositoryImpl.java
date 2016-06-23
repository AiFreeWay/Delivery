package appdoor.com.delivery.data.repositories;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import appdoor.com.delivery.data.cach_store.CacheStore;
import appdoor.com.delivery.data.cach_store.DBStore;
import appdoor.com.delivery.data.fast_store.FastStore;
import appdoor.com.delivery.data.mock_store.MockStore;
import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.domain.models.Table;

@Singleton
public class RepositoryImpl implements Repository {

    private MockStore mMockStore;
    private FastStore mFastStore;
    private DBStore mDBStore;
    private CacheStore mCacheStore;

    @Inject
    public RepositoryImpl(OrmLiteSqlHelper dataBaseHelper, Context context) {
        mMockStore = new MockStore();
        mFastStore = new FastStore();
        mDBStore = new DBStore(dataBaseHelper);
        mCacheStore = new CacheStore(context);
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

    @Override
    public Table getTable(int number) throws Exception {
        return mMockStore.getTable(number);
    }

    @Override
    public int getTableLocal() throws Exception {
        return mCacheStore.getTableNumber();
    }

    @Override
    public void postTable(Integer number) throws Exception {

    }
}
