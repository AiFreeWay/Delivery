package appdoor.com.delivery.presentation.view_controllers;


import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.EntranceFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentEntranceCtrl {

    @Inject @Named(ActivityModule.GET_TABLE_KEY)
    Interactor1<TableDomain, Integer> mGetTable;
    @Inject @Named(ActivityModule.POST_TABLE_KEY)
    Interactor1<Void, Integer> mPostTable;
    @Inject @Named(ActivityModule.GET_TABLE_LOCAL_KEY)
    Interactor<TableDomain> mGetTableLocal;
    @Inject @Named(ActivityModule.PUT_TABLE_LOCAL_KEY)
    Interactor1<Void, TableDomain> mPutTableLocal;
    @Inject @Named(ActivityModule.GET_ORDERED_KEY)
    Interactor<List<OrderedFoodDomain>> mGetOrdered;
    @Inject @Named(ActivityModule.EXIT_KEY)
    Interactor<Void> mExit;

    private EntranceFragment mFragment;
    private boolean isNeedCancel = false;

    public FragmentEntranceCtrl(EntranceFragment fragment) {
        mFragment = fragment;
        mFragment.getMainActivity().getComponent().inject(this);
    }

    public void start() {
        mGetTableLocal.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> {
                    if (table != null) {
                        spreadTable(table);
                        if (table.getStatus() == TableDomain.STATUS_OK)
                            getTable(table.getNumber());
                    }
                }, e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: start "+e.toString());
                    e.printStackTrace();
                });
    }

    public void sendTableNumber(int number) {
        mPostTable.execute(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> getTable(number))
                .doOnError(e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: sendTableNumber "+e.toString());
                    e.printStackTrace();
                })
                .subscribe();
    }

    public void needCancel() {
        isNeedCancel = true;
    }

    public void release() {
        mFragment.setStatusNone();
        exit();
    }

    private void getTable(int number) {
        mGetTable.execute(number).timeout(10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::spreadTable, e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: getTable "+e.toString());
                    e.printStackTrace();
                });
    }

    private void spreadTable(TableDomain table) {
        switch (table.getStatus()) {
            case TableDomain.STATUS_OK:
                doOnStateOk(table);
                break;
            case TableDomain.STATUS_WAIT:
                doOnStateWait(table);
                break;
            case TableDomain.STATUS_BUSY:
                doOnStateBusy();
                break;
            case TableDomain.STATUS_NONE:
                release();
                break;
        }
    }
    
    private void doOnStateOk(TableDomain table) {
        putTableLocal(table);
        mFragment.setStatusOk(table.getNumber());
        mGetOrdered.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(ordereds -> ordereds.size()>0)
                .subscribe(ordereds -> mFragment.getMainActivity().showOrderTitle(ordereds.size()), e -> {
                    Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: doOnStateOk " + e.toString());
                    e.printStackTrace();
                });
    }

    private void doOnStateWait(TableDomain table) {
        putTableLocal(table);
        if (!isNeedCancel) {
            mFragment.setStatusWait(table.getNumber());
            getTable(table.getNumber());
        } else {
            mFragment.setStatusNone();
            isNeedCancel = false;
        }
    }

    private void doOnStateBusy() {
        mFragment.setStatusBusy();
        exit();
    }

    private void putTableLocal(TableDomain table) {
        mPutTableLocal.execute(table)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: putTableLocal "+e.toString());
                    e.printStackTrace();
                })
                .subscribe();
    }

    private void exit() {
        mExit.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> mFragment.getMainActivity().hideOrderTitle())
                .doOnError(e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: getTable "+e.toString());
                    e.printStackTrace();
                }).subscribe();
    }
}
