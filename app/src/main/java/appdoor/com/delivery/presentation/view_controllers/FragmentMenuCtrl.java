package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

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
    private LayoutInflater mLayoutInflater;

    public FragmentMenuCtrl(MenuFragment fragment) {
        mFragment = fragment;
        mLayoutInflater = (LayoutInflater) mFragment.getMainActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetMenuCategory.execute().subscribe(foodMenu ->
            mFragment.getAdapter().loadData(foodMenu), e -> {});
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public MenuFragment getFragment() {
        return mFragment;
    }
}
