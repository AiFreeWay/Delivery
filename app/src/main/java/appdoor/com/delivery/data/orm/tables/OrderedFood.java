package appdoor.com.delivery.data.orm.tables;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = OrderedFood.TABLE_NAME)
public class OrderedFood {

    public final static String TABLE_NAME = "orderFoods";
    public final static String FIELD_NAME_ID = "id";
    public final static String FIELD_NAME_FOOD_ID = "food_id";
    public final static String FIELD_NAME_STATUS = "status";

    @DatabaseField(generatedId = true, canBeNull = false, dataType = DataType.INTEGER, columnName = FIELD_NAME_ID)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER, columnName = FIELD_NAME_FOOD_ID)
    private int food_id;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER, columnName = FIELD_NAME_STATUS)
    private int status;

    public OrderedFood() {
    }

    public OrderedFood(int food_id, int status) {
        this.food_id = food_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
