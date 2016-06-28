package appdoor.com.delivery.data.mappers;


import appdoor.com.delivery.data.orm.tables.MenuItem;
import appdoor.com.delivery.domain.models.MenuItemDomain;

public class MenuItemMapper {

    public static MenuItem mapMenuItem(MenuItemDomain menu) {
        return new MenuItem(menu.getId(), menu.getTitle(), menu.getSubTitle(), menu.getDescription(), menu.getImage());
    }

    public static MenuItemDomain mapMenuItem(MenuItem menu) {
        return new MenuItemDomain(menu.getId(), menu.getTitle(), menu.getSubTitle(), menu.getDescription(), menu.getImage());
    }
}
