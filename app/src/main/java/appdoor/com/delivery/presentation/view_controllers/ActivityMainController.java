package appdoor.com.delivery.presentation.view_controllers;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;

import appdoor.com.delivery.presentation.views.activities.MainActivity;

public class ActivityMainController implements ViewController {

    private MainActivity mActivity;
    private LayoutInflater mLayoutInflater;

    public ActivityMainController(MainActivity mActivity) {
        this.mActivity = mActivity;
        mLayoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public MainActivity getActivity() {
        return mActivity;
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public Drawable getDrawableByRes(int res) {
        return mActivity.getResources().getDrawable(res);
    }
}
