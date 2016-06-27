package appdoor.com.delivery.data.mappers;


import appdoor.com.delivery.data.orm.tables.OrderTable;
import appdoor.com.delivery.domain.models.TableDomain;

public class TableMapper {

    public static TableDomain mapTable(OrderTable table) {
        return new TableDomain(table.getNumber(), table.getStatus());
    }

    public static OrderTable mapTable(TableDomain table) {
        return new OrderTable(table.getNumber(), table.getStatus());
    }
}
