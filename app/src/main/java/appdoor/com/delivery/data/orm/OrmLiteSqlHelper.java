package appdoor.com.delivery.data.orm;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import appdoor.com.delivery.data.orm.dao.OrderTableDAO;
import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.presentation.app.DeliveryApplication;

public class OrmLiteSqlHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME ="myappname.db";
    private static final int VERSION = 1;

    private OrderTableDAO mOrderTableDao = null;

    public OrmLiteSqlHelper(Context context) {
        super(context,DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, OrderTable.class);
        } catch (SQLException e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "OrmLiteSqlHelper: onCreate "+e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, OrderTable.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "OrmLiteSqlHelper: onUpgrade "+e.toString());
        }
    }

    public OrderTableDAO getOrderTableDAO() throws SQLException{
        if(mOrderTableDao == null)
            mOrderTableDao = new OrderTableDAO(getConnectionSource(), OrderTable.class);
        return mOrderTableDao;
    }

    @Override
    public void close(){
        super.close();
        mOrderTableDao = null;
    }
}
