package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.presentation.models.MenuItem;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.views.activities.MainActivity;
import appdoor.com.delivery.presentation.views.fragments.BaseFragment;

public class ActivityMainCtrl {

    @Inject
    FragmentsFactory mFragmentFactory;
    @Inject
    FragmentRouter mRouter;
    @Inject
    MenuFactory mMenuFactory;

    private MainActivity mActivity;
    private LayoutInflater mLayoutInflater;

    public ActivityMainCtrl(MainActivity mActivity) {
        this.mActivity = mActivity;
        mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mActivity.getComponent().inject(this);
    }

    public void start(Bundle savedInstanceState) {
        mActivity.getAdapter().loadData(getMenuItems());
        if (savedInstanceState == null)
            showFragmentsFromMenu(MenuFactory.MenuItems.ENTRANCE);
    }

    public void showFragmentsFromMenu(MenuFactory.MenuItems menuItemsId) {
        MenuItem item = mMenuFactory.getFragment(menuItemsId);
        showFragments(item);
    }

    public void showFragments(MenuItem item) {
        BaseFragment fragment = mFragmentFactory.getFragment(item.getFragmentsType());
        fragment.getArguments().putSerializable(BaseFragment.MENU_ITEM_KEY, item);
        mRouter.show(fragment);
    }

    public void onFragmentLoad(MenuItem item) {
        mActivity.setTitle(item.getTitle());
        selectedMenuItems(item);
        mActivity.getAdapter().notifyDataSetChanged();
        mActivity.closeMenu();
    }

    public void popBack() {
        mRouter.back();
    }

    public List<MenuItem> getMenuItems() {
        return mMenuFactory.getMenuItems();
    }

    public MainActivity getActivity() {
        return mActivity;
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public Drawable getDrawableByRes(int res) {
        return mActivity.getResources().getDrawable(res);
    }

    private void selectedMenuItems(MenuItem selectedItem) {
        List<MenuItem> menuItems = mActivity.getAdapter()
                .getData();
        for (MenuItem item : menuItems)
            item.setSelected(item.getFragmentsType().id == selectedItem.getFragmentsType().id);
    }
}
