package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.presentation.adapters.MultyAdapter;
import appdoor.com.delivery.presentation.adapters.view_binders.MenuBinder;
import appdoor.com.delivery.presentation.view_controllers.FragmentMenuCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends BaseFragment {

    @BindView(R.id.fmt_list_lv_main)
    ListView mLvMain;

    private FragmentMenuCtrl mViewController;
    private MultyAdapter<MenuItemDomain> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewController = new FragmentMenuCtrl(this);
        mAdapter = new MultyAdapter<MenuItemDomain>(new MenuBinder(mViewController));
        mLvMain.setAdapter(mAdapter);
        mViewController.start();
    }

    public ListView getLvMain() {
        return mLvMain;
    }

    public MultyAdapter<MenuItemDomain> getAdapter() {
        return mAdapter;
    }
}
