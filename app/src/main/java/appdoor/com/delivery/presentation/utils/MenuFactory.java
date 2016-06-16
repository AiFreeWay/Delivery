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
        mMenuItems.add(new MenuItem(R.drawable.ic_entrance_selected, R.drawable.ic_entrance_selected, "Войти", FragmentsFactory.Fragments.ENTRANCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_menu, R.drawable.ic_menu_selected, "Меню", FragmentsFactory.Fragments.ENTRANCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_service, R.drawable.ic_service_selected, "Услуги", FragmentsFactory.Fragments.ENTRANCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_ordered, R.drawable.ic_ordered_selected, "Заказанное", FragmentsFactory.Fragments.ENTRANCE));
        mMenuItems.add(new MenuItem(R.drawable.ic_info, R.drawable.ic_info_selected, "О заведении", FragmentsFactory.Fragments.ENTRANCE));
    }

    public List<MenuItem> getMenuItems() {
        return mMenuItems;
    }
}
