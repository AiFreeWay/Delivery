package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.OrderedFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentOrderedCtrl {

    @Inject  @Named(ActivityModule.GET_ORDERED_KEY)
    Interactor<List<OrderedFoodDomain>> mGetOrdered;
    @Inject @Named(ActivityModule.GET_TABLE_LOCAL_KEY)
    Interactor<TableDomain> mGetTableLocal;

    private OrderedFragment mFragment;
    private LayoutInflater mLayoutInflater;

    public FragmentOrderedCtrl(OrderedFragment fragment) {
        mFragment = fragment;
        mLayoutInflater = (LayoutInflater) mFragment.getMainActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetTableLocal.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(t -> t != null && t.getStatus() == TableDomain.STATUS_OK)
                .flatMap(t -> mGetOrdered.execute())
                .subscribe(orderedFoods -> mFragment.getAdapter().loadData(orderedFoods), e -> {
                    Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentOrderedCtrl: start " + e.toString());
                    e.printStackTrace();
                });
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public OrderedFragment getFragment() {
        return mFragment;
    }
}
