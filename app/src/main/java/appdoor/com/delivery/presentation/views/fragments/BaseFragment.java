package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import appdoor.com.delivery.presentation.models.AppMenuItem;
import appdoor.com.delivery.presentation.views.activities.MainActivity;

public abstract class BaseFragment extends Fragment {

    public static final String APP_MENU_ITEM_KEY = "mnittly";
    protected AppMenuItem mAppMenuItem;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAppMenuItem = (AppMenuItem) getArguments().getSerializable(APP_MENU_ITEM_KEY);
        if (mAppMenuItem != null)
            getMainActivity().getViewController().onFragmentLoad(mAppMenuItem);
    }

    public AppMenuItem getAppMenuItem() {
        return mAppMenuItem;
    }

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
