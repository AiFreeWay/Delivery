package appdoor.com.delivery.presentation.view_controllers;


import android.util.Log;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.executors.GetMenuCategory;
import appdoor.com.delivery.domain.models.MenuCategory;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.MenuFragment;

public class FragmentMenuCtrl {

    @Inject @Named(ActivityModule.GET_MENU_CATEGORY)
    Interactor<List<MenuCategory>> mGetMenuCategory;

    private MenuFragment mFragment;

    public FragmentMenuCtrl(MenuFragment fragment) {
        this.mFragment = fragment;
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetMenuCategory.execute().subscribe(foodMenu -> {
            for (MenuCategory menuCategory : foodMenu)
                Log.d("++++", "FragmentMenuCtrl: start "+menuCategory.getTitle());
        }, e -> {});
    }
}
