package appdoor.com.delivery.presentation.utils;


import java.util.ArrayList;
import java.util.List;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.models.MenuItem;

public class MenuFactory {

    private List<MenuItem> mMenuItems;

    public MenuFactory() {
        mMenuItems = new ArrayList<MenuItem>();
        generateFragments();
    }

    private void generateFragments() {
        mMenuItems.add(new MenuItem(R.drawable.ic_entrance, R.drawable.ic_entrance_selected, "Войти", FragmentsFactory.Fragments.ENTRANCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_menu, R.drawable.ic_menu_selected, "Меню", FragmentsFactory.Fragments.MENU));
        mMenuItems.add(new MenuItem(R.drawable.ic_service, R.drawable.ic_service_selected, "Услуги", FragmentsFactory.Fragments.SERIVCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_ordered, R.drawable.ic_ordered_selected, "Заказанное", FragmentsFactory.Fragments.ORDERED));
        mMenuItems.add(new MenuItem(R.drawable.ic_info, R.drawable.ic_info_selected, "О заведении", FragmentsFactory.Fragments.ABOUT));
    }

    public List<MenuItem> getMenuItems() {
        return mMenuItems;
    }

    public MenuItem getFragment(MenuItems menuItemsIndefinder) {
        return mMenuItems.get(menuItemsIndefinder.id);
    }

    public enum MenuItems {
        ENTRANCE(0),
        MENU(1),
        SERIVCE(2),
        ORDERED(3),
        ABOUT(4);

        int id;
        MenuItems(int id) {
            this.id = id;
        }
    }
}
