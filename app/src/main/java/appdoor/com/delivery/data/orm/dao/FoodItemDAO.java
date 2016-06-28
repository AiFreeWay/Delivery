package appdoor.com.delivery.data.orm.dao;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import appdoor.com.delivery.data.orm.tables.FoodItem;

public class FoodItemDAO extends BaseDaoImpl<FoodItem, Integer> {

    public FoodItemDAO(ConnectionSource connectionSource, Class<FoodItem> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
