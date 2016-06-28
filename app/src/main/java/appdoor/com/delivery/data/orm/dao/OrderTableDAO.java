package appdoor.com.delivery.data.orm.dao;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import appdoor.com.delivery.data.orm.tables.OrderTable;

public class OrderTableDAO extends BaseDaoImpl<OrderTable, Integer> {

    public OrderTableDAO(ConnectionSource connectionSource, Class<OrderTable> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
