package appdoor.com.delivery.presentation.view_controllers;


import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.models.Table;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.views.fragments.EntranceFragment;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentEntranceCtrl {

    @Inject @Named(ActivityModule.GET_TABLE_KEY)
    Interactor1<Table, Integer> mGetTable;
    @Inject @Named(ActivityModule.POST_TABLE_KEY)
    Interactor1<Void, Integer> mPostTable;
    @Inject @Named(ActivityModule.GET_TABLE_LOCAL_KEY)
    Interactor<Table> mGetTableLocal;
    @Inject @Named(ActivityModule.PUT_TABLE_LOCAL_KEY)
    Interactor1<Void, Table> mPutTableLocal;

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
                        if (table.getStatus() == Table.STATUS_OK)
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

    public void exit() {
        mFragment.setStatusNone();
        putTableLocal(null);
    }

    private void getTable(int number) {
        mGetTable.execute(number).timeout(10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::spreadTable, e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: getTable "+e.toString());
                    e.printStackTrace();
                });
    }

    private void spreadTable(Table table) {
        switch (table.getStatus()) {
            case Table.STATUS_OK:
                mFragment.setStatusOk(table.getNumber());
                putTableLocal(table);
                break;
            case Table.STATUS_WAIT:
                putTableLocal(table);
                if (!isNeedCancel) {
                    mFragment.setStatusWait(table.getNumber());
                    getTable(table.getNumber());
                } else {
                    mFragment.setStatusNone();
                    isNeedCancel = false;
                }
                break;
            case Table.STATUS_BUSY:
                mFragment.setStatusBusy();
                putTableLocal(null);
                break;
            case Table.STATUS_NONE:
                exit();
                break;
        }
    }

    private void putTableLocal(Table table) {
        mPutTableLocal.execute(table)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(e -> { Log.e(DeliveryApplication.UNIVERSAL_APP_ERROR_TAG, "FragmentEntranceCtrl: putTableLocal "+e.toString());
                    e.printStackTrace();
                })
                .subscribe();
    }
}
