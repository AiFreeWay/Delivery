package appdoor.com.delivery.data.orm.dao;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import appdoor.com.delivery.data.orm.tables.FoodItem;
import appdoor.com.delivery.data.orm.tables.MenuItem;

public class MenuItemDAO extends BaseDaoImpl<MenuItem, Integer> {

    public MenuItemDAO(ConnectionSource connectionSource, Class<MenuItem> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}