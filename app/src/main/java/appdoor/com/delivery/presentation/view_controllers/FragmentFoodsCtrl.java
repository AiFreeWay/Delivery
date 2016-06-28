package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.github.florent37.viewanimator.ViewAnimator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.FoodsFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentFoodsCtrl {

    @Inject @Named(ActivityModule.GET_FOODS_KEY)
    Interactor1<List<FoodItemDomain>, Integer> mGetFoods;
    @Inject @Named(ActivityModule.GET_TABLE_LOCAL_KEY)
    Interactor<TableDomain> mGetTableLocal;
    @Inject @Named(ActivityModule.ADD_ORDER_TO_CART_KEY)
    Interactor1<Void, FoodItemDomain> mAddOrder;
    @Inject @Named(ActivityModule.GET_ORDERED_KEY)
    Interactor<List<OrderedFoodDomain>> mGetOrdered;

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

    public void toOrder(FoodItemDomain data, View animateView) {
        mGetTableLocal.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(t -> t != null && t.getStatus() == TableDomain.STATUS_OK)
                .flatMap(t -> mAddOrder.execute(data))
                .subscribe((aVoid) -> doOnOrderView(animateView), e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentFoodsCtrl: toOrder "+e.toString());
                    e.printStackTrace();});
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public FoodsFragment getFragment() {
        return mFragment;
    }

    private void doOnOrderView(View animateView) {
        ViewAnimator.animate(animateView)
                .backgroundColor(Color.parseColor("#FF9800"), Color.WHITE)
                .duration(700)
                .start();

        mGetOrdered.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(orderedFoods -> getFragment().getMainActivity().showOrderTitle(orderedFoods.size()), e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentFoodsCtrl: doOnOrderView "+e.toString());
                    e.printStackTrace();});

    }
}
