package appdoor.com.delivery.data.orm;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import appdoor.com.delivery.data.orm.dao.FoodItemDAO;
import appdoor.com.delivery.data.orm.dao.MenuItemDAO;
import appdoor.com.delivery.data.orm.dao.OrderTableDAO;
import appdoor.com.delivery.data.orm.dao.OrderedFoodDAO;
import appdoor.com.delivery.data.orm.tables.FoodItem;
import appdoor.com.delivery.data.orm.tables.MenuItem;
import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.data.orm.tables.OrderedFood;
import appdoor.com.delivery.presentation.app.DeliveryApplication;

public class OrmLiteSqlHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME ="myappname.db";
    private static final int VERSION = 1;

    private OrderTableDAO mOrderTableDAO = null;
    private FoodItemDAO mFoodItemDAO = null;
    private MenuItemDAO mMenuItemDAO = null;
    private OrderedFoodDAO mOrderedFoodDAO= null;

    public OrmLiteSqlHelper(Context context) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, OrderTable.class);
            TableUtils.createTable(connectionSource, FoodItem.class);
            TableUtils.createTable(connectionSource, MenuItem.class);
            TableUtils.createTable(connectionSource, OrderedFood.class);
        } catch (SQLException e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "OrmLiteSqlHelper: onCreate "+e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, OrderTable.class, true);
            TableUtils.dropTable(connectionSource, FoodItem.class, true);
            TableUtils.dropTable(connectionSource, MenuItem.class, true);
            TableUtils.dropTable(connectionSource, OrderedFood.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "OrmLiteSqlHelper: onUpgrade "+e.toString());
            e.printStackTrace();
        }
    }

    public OrderTableDAO getOrderTableDAO() throws SQLException{
        if(mOrderTableDAO == null)
            mOrderTableDAO = new OrderTableDAO(getConnectionSource(), OrderTable.class);
        return mOrderTableDAO;
    }

    public FoodItemDAO getFoodItemDAO() throws SQLException{
        if(mFoodItemDAO == null)
            mFoodItemDAO = new FoodItemDAO(getConnectionSource(), FoodItem.class);
        return mFoodItemDAO;
    }

    public MenuItemDAO getMenuItemDAO() throws SQLException{
        if(mMenuItemDAO == null)
            mMenuItemDAO = new MenuItemDAO(getConnectionSource(), MenuItem.class);
        return mMenuItemDAO;
    }

    public OrderedFoodDAO getOrderedFoodDAO() throws SQLException{
        if(mOrderedFoodDAO == null)
            mOrderedFoodDAO = new OrderedFoodDAO(getConnectionSource(), OrderedFood.class);
        return mOrderedFoodDAO;
    }

    @Override
    public void close(){
        super.close();
        mOrderTableDAO = null;
        mFoodItemDAO = null;
        mMenuItemDAO = null;
        mOrderedFoodDAO = null;
    }
}
