package appdoor.com.delivery.data.mappers;


import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.domain.models.Table;

public class TableMapper {

    public static Table mapTable(OrderTable table) {
        return new Table(table.getNumber(), table.getStatus());
    }
}
