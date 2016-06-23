package appdoor.com.delivery.data.cach_store;


import android.util.Log;


import java.util.List;

import appdoor.com.delivery.data.mappers.TableMapper;
import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.data.orm.dao.OrderTableDAO;
import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.domain.models.Table;
import appdoor.com.delivery.presentation.app.DeliveryApplication;

public class DBStore {

    private OrmLiteSqlHelper mDataBaseHelper;
    private OrderTableDAO mOrderTableDAO;

    public DBStore(OrmLiteSqlHelper dataBaseHelper) {
        mDataBaseHelper = dataBaseHelper;
        try {
            mOrderTableDAO = new OrderTableDAO(mDataBaseHelper.getConnectionSource(), OrderTable.class);
        } catch (Exception e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "DBStore: DBStore "+e.toString());
        }
    }

    public Table getTable() throws Exception {
        List<OrderTable> tables = mOrderTableDAO.queryForAll();
        if (tables.size() > 0)
            return TableMapper.mapTable(tables.get(0));
        return null;
    }
}
