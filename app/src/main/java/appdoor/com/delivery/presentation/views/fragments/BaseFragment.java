package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import appdoor.com.delivery.presentation.models.MenuItem;
import appdoor.com.delivery.presentation.views.activities.BaseActivity;
import appdoor.com.delivery.presentation.views.activities.MainActivity;

public abstract class BaseFragment extends Fragment {

    public static final String MENU_ITEM_KEY = "mnittly";
    protected MenuItem mMenuItem;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMenuItem = (MenuItem) getArguments().getSerializable(MENU_ITEM_KEY);
        if (mMenuItem != null)
            getMainActivity().getViewController().onFragmentLoad(mMenuItem);
    }

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
