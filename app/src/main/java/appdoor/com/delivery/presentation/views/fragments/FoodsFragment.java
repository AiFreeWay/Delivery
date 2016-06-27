package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.presentation.adapters.MultyAdapter;
import appdoor.com.delivery.presentation.adapters.view_binders.FoodsBinder;
import appdoor.com.delivery.presentation.view_controllers.FragmentFoodsCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodsFragment extends BaseFragment {

    public static final String MENU_ITEM_KEY = "fooditemcat";

    @BindView(R.id.fmt_list_lv_main)
    ListView mLvMain;

    private FragmentFoodsCtrl mViewController;
    private MenuItemDomain mMenuItem;
    private MultyAdapter<FoodItemDomain> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMenuItem = (MenuItemDomain) getArguments().getSerializable(MENU_ITEM_KEY);
        getMainActivity().setTitle(mMenuItem.getTitle());
        mViewController = new FragmentFoodsCtrl(this);
        mAdapter = new MultyAdapter<FoodItemDomain>(new FoodsBinder(mViewController));
        mLvMain.setAdapter(mAdapter);
        mViewController.start();
    }

    public ListView getLvMain() {
        return mLvMain;
    }

    public MultyAdapter<FoodItemDomain> getAdapter() {
        return mAdapter;
    }

    public MenuItemDomain getMenuItem() {
        return mMenuItem;
    }
}
