package appdoor.com.delivery.data.orm.tables;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = OrderTable.TABLE_NAME)
public class OrderTable {

    public static final int SINGLE_ROW_TABLE_ID = 1;
    public final static String TABLE_NAME = "orderTable";
    public final static String FIELD_NAME_ID = "id";
    public final static String FIELD_NAME_NUMBER = "number";
    public final static String FIELD_NAME_STATUS = "status";

    @DatabaseField(id = true, canBeNull = true, dataType = DataType.INTEGER, columnName = FIELD_NAME_ID)
    private int id;

    @DatabaseField(canBeNull = true, dataType = DataType.INTEGER, columnName = FIELD_NAME_NUMBER)
    private int number;

    @DatabaseField(canBeNull = true, dataType = DataType.INTEGER, columnName = FIELD_NAME_STATUS)
    private int status;

    public OrderTable() {

    }

    public OrderTable(int number, int status) {
        id = SINGLE_ROW_TABLE_ID;
        this.number = number;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
