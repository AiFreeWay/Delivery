package appdoor.com.delivery.data.local_store;


import android.util.Log;


import com.j256.ormlite.table.TableUtils;

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
            mOrderTableDAO = mDataBaseHelper.getOrderTableDAO();
            mMenuItemDAO = mDataBaseHelper.getMenuItemDAO();
            mFoodItemDAO = mDataBaseHelper.getFoodItemDAO();
            mOrderedFoodDAO = mDataBaseHelper.getOrderedFoodDAO();
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
        if (!mOrderTableDAO.idExists(OrderTable.SINGLE_ROW_TABLE_ID))
            mOrderTableDAO.createOrUpdate(TableMapper.mapTable(table));
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
        for (MenuItem menuItem : mMenuItemDAO.queryForAll())
            menu.add(MenuItemMapper.mapMenuItem(menuItem));
        return menu;
    }

    public List<FoodItemDomain> getFoods(int categoryId) throws Exception {
        List<FoodItemDomain> foods = new LinkedList<FoodItemDomain>();
        for (FoodItem foodItem : mFoodItemDAO.queryForEq(FoodItem.FIELD_NAME_CATEGORY_ID, categoryId))
            foods.add(FoodItemMapper.mapFoodItem(foodItem));
        return foods;
    }

    public List<FoodItemDomain> getFoods() throws Exception {
        List<FoodItemDomain> foods = new LinkedList<FoodItemDomain>();
        for (FoodItem foodItem : mFoodItemDAO.queryForAll())
            foods.add(FoodItemMapper.mapFoodItem(foodItem));
        return foods;
    }

    public int getOrderedFoodsCount() throws Exception {
        return (int) mOrderedFoodDAO.countOf();
    }

    public List<OrderedFoodDomain> getOrderedFoods() throws Exception {
        List<OrderedFoodDomain> orderedFoods = new LinkedList<OrderedFoodDomain>();
        List<FoodItemDomain> foods = getFoods();
        for (OrderedFood orderedFood : mOrderedFoodDAO.queryForAll())
            orderedFoods.add(OrderedFoodMapper.mapOrdered(orderedFood, findFood(foods, orderedFood.getFoodId())));
        return orderedFoods;
    }

    public void removeTable() throws Exception {
        mOrderTableDAO.deleteById(OrderTable.SINGLE_ROW_TABLE_ID);
    }

    public void removeOrdered() throws Exception {
        TableUtils.clearTable(mDataBaseHelper.getConnectionSource(), OrderedFood.class);
    }

    private FoodItemDomain findFood(List<FoodItemDomain> foods, int foodId) {
        for (FoodItemDomain food : foods)
            if (food.getId() == foodId)
                return food;
        return null;
    }
}
