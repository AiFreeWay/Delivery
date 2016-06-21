package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.views.fragments.BaseFragment;
import appdoor.com.delivery.presentation.views.fragments.FoodsFragment;
import appdoor.com.delivery.presentation.views.fragments.MenuFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentMenuCtrl {

    @Inject @Named(ActivityModule.GET_MENU_KEY)
    Interactor<List<MenuItem>> mGetMenu;
    @Inject
    FragmentRouter mRouter;
    @Inject
    FragmentsFactory mFragmentFactory;

    private MenuFragment mFragment;
    private LayoutInflater mLayoutInflater;

    public FragmentMenuCtrl(MenuFragment fragment) {
        mFragment = fragment;
        mLayoutInflater = (LayoutInflater) mFragment.getMainActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetMenu.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(menu -> mFragment.getAdapter().loadData(menu), e -> Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentMenuCtrl: start "+e.toString()));
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public MenuFragment getFragment() {
        return mFragment;
    }

    public void showFragment(MenuItem category) {
        BaseFragment fragment = mFragmentFactory.getFragment(FragmentsFactory.Fragments.FOODS);
        fragment.getArguments().putSerializable(BaseFragment.APP_MENU_ITEM_KEY, mFragment.getAppMenuItem());
        fragment.getArguments().putSerializable(FoodsFragment.MENU_ITEM_KEY, category);
        mRouter.show(fragment);
    }
}
