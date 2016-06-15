package appdoor.com.delivery.presentation.views.fragments;


import android.support.v4.app.Fragment;

import appdoor.com.delivery.presentation.views.activities.BaseActivity;

public abstract class BaseFragment extends Fragment {

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }
}
