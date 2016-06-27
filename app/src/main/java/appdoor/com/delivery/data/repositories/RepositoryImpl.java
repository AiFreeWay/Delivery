package appdoor.com.delivery.data.repositories;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import appdoor.com.delivery.data.local_store.CacheStore;
import appdoor.com.delivery.data.local_store.DBStore;
import appdoor.com.delivery.data.fast_store.FastStore;
import appdoor.com.delivery.data.mock_store.MockStore;
import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;

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
    public List<MenuItemDomain> getMenu() throws Exception {
        List<MenuItemDomain> menu = mMockStore.getMenu();
        if (menu == null)
            menu = mDBStore.getMenu();
        return menu;
    }

    @Override
    public List<FoodItemDomain> getFoods(int categoryId) throws Exception {
        List<FoodItemDomain> foods = mMockStore.getFoods();
        if (foods == null)
            foods = mDBStore.getFoods(categoryId);
        return foods;
    }

    @Override
    public TableDomain getTable(int number) throws Exception {
        return mMockStore.getTable(number);
    }

    @Override
    public TableDomain getTableLocal() throws Exception {
        return mDBStore.getTable();
    }

    @Override
    public void postTable(TableDomain tableDomain) throws Exception {

    }

    @Override
    public void putTableLocal(TableDomain table) throws Exception {
        mDBStore.putTable(table);
    }

    @Override
    public void addOrderedtoCart(OrderedFoodDomain food) throws Exception {
        mDBStore.addOrderToCart(food);
    }

    @Override
    public void cacheMenu(List<MenuItemDomain> menu) throws Exception {
        mDBStore.cacheMenu(menu);
    }

    @Override
    public void cacheFoods(List<FoodItemDomain> foods) throws Exception {
        mDBStore.cacheFoods(foods);
    }
}
