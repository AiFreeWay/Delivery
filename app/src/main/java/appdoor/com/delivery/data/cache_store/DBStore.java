package appdoor.com.delivery.data.cache_store;


import android.util.Log;


import java.util.LinkedList;
import java.util.List;

import appdoor.com.delivery.data.mappers.FoodItemMapper;
import appdoor.com.delivery.data.mappers.MenuItemMapper;
import appdoor.com.delivery.data.mappers.OrderedFoodMapper;
import appdoor.com.delivery.data.mappers.TableMapper;
import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.data.orm.dao.FoodItemDAO;
import appdoor.com.delivery.data.orm.dao.MenuItemDAO;
import appdoor.com.delivery.data.orm.dao.OrderTableDAO;
import appdoor.com.delivery.data.orm.dao.OrderedFoodDAO;
import appdoor.com.delivery.data.orm.tables.FoodItem;
import appdoor.com.delivery.data.orm.tables.MenuItem;
import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.data.orm.tables.OrderedFood;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;
import appdoor.com.delivery.presentation.app.DeliveryApplication;

public class DBStore {

    private OrmLiteSqlHelper mDataBaseHelper;
    private OrderTableDAO mOrderTableDAO;
    private MenuItemDAO mMenuItemDAO;
    private FoodItemDAO mFoodItemDAO;
    private OrderedFoodDAO mOrderedFoodDAO;

    public DBStore(OrmLiteSqlHelper dataBaseHelper) {
        mDataBaseHelper = dataBaseHelper;
        try {
            mOrderTableDAO = new OrderTableDAO(mDataBaseHelper.getConnectionSource(), OrderTable.class);
            mMenuItemDAO = new MenuItemDAO(mDataBaseHelper.getConnectionSource(), MenuItem.class);
            mFoodItemDAO = new FoodItemDAO(mDataBaseHelper.getConnectionSource(), FoodItem.class);
            mOrderedFoodDAO = new OrderedFoodDAO(mDataBaseHelper.getConnectionSource(), OrderedFood.class);
        } catch (Exception e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "DBStore: DBStore "+e.toString());
            e.printStackTrace();
        }
    }

    public TableDomain getTable() throws Exception {
        OrderTable table = mOrderTableDAO.queryForId(OrderTable.SINGLE_ROW_TABLE_ID);
        if (table != null)
            return TableMapper.mapTable(table);
        return null;
    }

    public void putTable(TableDomain table) throws Exception {
        if (table == null)
            mOrderTableDAO.deleteById(OrderTable.SINGLE_ROW_TABLE_ID);
        else {
            if (!mOrderTableDAO.idExists(OrderTable.SINGLE_ROW_TABLE_ID))
                mOrderTableDAO.create(TableMapper.mapTable(table));
        }
    }

    public void addOrderToCart(OrderedFoodDomain orderedFood) throws Exception {
        mOrderedFoodDAO.create(OrderedFoodMapper.mapOrdered(orderedFood));
    }

    public void cacheMenu(List<MenuItemDomain> menu) throws Exception {
        for (MenuItemDomain menuItemDomain : menu)
            mMenuItemDAO.createOrUpdate(MenuItemMapper.mapMenuItem(menuItemDomain));
    }

    public void cacheFoods(List<FoodItemDomain> foods) throws Exception {
        for (FoodItemDomain foodItemDomain : foods)
            mFoodItemDAO.createOrUpdate(FoodItemMapper.mapFoodItem(foodItemDomain));
    }

    public List<MenuItemDomain> getMenu() throws Exception {
        List<MenuItemDomain> menu = new LinkedList<MenuItemDomain>();
        for (MenuItem menuItem :mMenuItemDAO.queryForAll())
            menu.add(MenuItemMapper.mapMenuItem(menuItem));
        return menu;
    }

    public List<FoodItemDomain> getFoods(int categoryId) throws Exception {
        List<FoodItemDomain> foods = new LinkedList<FoodItemDomain>();
        for (FoodItem foodItem :mFoodItemDAO.queryForEq(FoodItem.FIELD_NAME_CATEGORY_ID, categoryId))
            foods.add(FoodItemMapper.mapFoodItem(foodItem));
        return foods;
    }
}
