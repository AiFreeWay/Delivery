package appdoor.com.delivery.data.orm.dao;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.data.orm.tables.OrderedFood;

public class OrderedFoodDAO extends BaseDaoImpl<OrderedFood, Integer> {

    public OrderedFoodDAO(ConnectionSource connectionSource, Class<OrderedFood> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}

