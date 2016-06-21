package appdoor.com.delivery.presentation.views.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.view_controllers.FragmentMenuCtrl;
import butterknife.ButterKnife;

public class MenuFragment extends BaseFragment {

    private FragmentMenuCtrl mViewController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_entrance, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewController = new FragmentMenuCtrl(this);
        mViewController.start();
    }
}
