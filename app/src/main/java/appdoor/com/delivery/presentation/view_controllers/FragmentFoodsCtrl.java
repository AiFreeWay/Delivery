package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.FoodsFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentFoodsCtrl {

    @Inject @Named(ActivityModule.GET_FOODS_KEY)
    Interactor1<List<FoodItem>, Integer> mGetFoods;

    private FoodsFragment mFragment;
    private LayoutInflater mLayoutInflater;

    public FragmentFoodsCtrl(FoodsFragment fragment) {
        mFragment = fragment;
        mLayoutInflater = (LayoutInflater) mFragment.getMainActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetFoods.execute(mFragment.getMenuItem().getId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(foods -> mFragment.getAdapter().loadData(foods), e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentFoodsCtrl: start "+e.toString());
                    e.printStackTrace();
                });
    }

    public void toOrder(FoodItem data) {

    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public FoodsFragment getFragment() {
        return mFragment;
    }
}
