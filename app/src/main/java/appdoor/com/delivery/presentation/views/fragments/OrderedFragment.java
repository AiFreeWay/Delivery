package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.presentation.adapters.MultyAdapter;
import appdoor.com.delivery.presentation.adapters.view_binders.OrderedBinder;
import appdoor.com.delivery.presentation.view_controllers.FragmentOrderedCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderedFragment extends BaseFragment {

    @BindView(R.id.fmt_list_lv_main)
    ListView mLvMain;

    private FragmentOrderedCtrl mViewController;
    private MultyAdapter<OrderedFoodDomain> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewController = new FragmentOrderedCtrl(this);
        mAdapter = new MultyAdapter<OrderedFoodDomain>(new OrderedBinder(mViewController));
        mLvMain.setAdapter(mAdapter);
        mViewController.start();
    }

    public ListView getLvMain() {
        return mLvMain;
    }

    public MultyAdapter<OrderedFoodDomain> getAdapter() {
        return mAdapter;
    }
}
