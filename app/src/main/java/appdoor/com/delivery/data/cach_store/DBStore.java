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
            e.printStackTrace();
        }
    }

    public Table getTable() throws Exception {
        OrderTable table = mOrderTableDAO.queryForId(OrderTable.SINGLE_ROW_TABLE_ID);
        if (table != null)
            return TableMapper.mapTable(table);
        return null;
    }

    public void putTable(Table table) throws Exception {
        if (table == null)
            mOrderTableDAO.deleteById(OrderTable.SINGLE_ROW_TABLE_ID);
        else {
            if (!mOrderTableDAO.idExists(OrderTable.SINGLE_ROW_TABLE_ID))
                mOrderTableDAO.create(TableMapper.mapTable(table));
        }
    }
}
