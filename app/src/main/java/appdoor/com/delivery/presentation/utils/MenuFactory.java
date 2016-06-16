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
        mMenuItems.add(new MenuItem(R.mipmap.ic_launcher, R.mipmap.ic_launcher, "Главный", FragmentsFactory.Fragments.MAIN));
        mMenuItems.add(new MenuItem(R.mipmap.ic_launcher, R.mipmap.ic_launcher, "Главный 2", FragmentsFactory.Fragments.MAIN));
        mMenuItems.add(new MenuItem(R.mipmap.ic_launcher, R.mipmap.ic_launcher, "Главный   3", FragmentsFactory.Fragments.MAIN));
    }

    public List<MenuItem> getMenuItems() {
        return mMenuItems;
    }
}
