package appdoor.com.delivery.presentation.utils;


import java.util.ArrayList;
import java.util.List;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.models.AppMenuItem;

public class MenuFactory {

    private List<AppMenuItem> mAppMenuItems;

    public MenuFactory() {
        mAppMenuItems = new ArrayList<AppMenuItem>();
        generateFragments();
    }

    private void generateFragments() {
        mAppMenuItems.add(new AppMenuItem(R.drawable.ic_entrance, R.drawable.ic_entrance_selected, "Войти", FragmentsFactory.Fragments.ENTRANCE));
        mAppMenuItems.add(new AppMenuItem(R.drawable.ic_menu, R.drawable.ic_menu_selected, "Меню", FragmentsFactory.Fragments.MENU));
        mAppMenuItems.add(new AppMenuItem(R.drawable.ic_service, R.drawable.ic_service_selected, "Услуги", FragmentsFactory.Fragments.SERIVCE));
        mAppMenuItems.add(new AppMenuItem(R.drawable.ic_ordered, R.drawable.ic_ordered_selected, "Заказанное", FragmentsFactory.Fragments.ORDERED));
        mAppMenuItems.add(new AppMenuItem(R.drawable.ic_info, R.drawable.ic_info_selected, "О заведении", FragmentsFactory.Fragments.ABOUT));
    }

    public List<AppMenuItem> getMenuItems() {
        return mAppMenuItems;
    }

    public AppMenuItem getFragment(MenuItems menuItemsIndefinder) {
        return mAppMenuItems.get(menuItemsIndefinder.id);
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
