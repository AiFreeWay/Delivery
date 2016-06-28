package appdoor.com.delivery.presentation.adapters.view_binders;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.models.AppMenuItem;
import appdoor.com.delivery.presentation.view_controllers.ActivityMainCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AppMenuBinder implements AbstractBinder<AppMenuItem> {

    @BindView(R.id.v_app_menu_item_iv_left_image)
    ImageView mIvLeftImage;
    @BindView(R.id.v_app_menu_item_tv_title)
    TextView mTvTitle;

    private ActivityMainCtrl mViewController;
    private ListView mParent;
    private LayoutInflater mLayoutInflater;

    public AppMenuBinder(ActivityMainCtrl controller) {
        mViewController = controller;
        mParent = mViewController.getActivity().getLvMenu();
        mLayoutInflater = mViewController.getLayoutInflater();
    }

    @Override
    public View bind(View view, AppMenuItem data) {
        if (view == null)
            view = mLayoutInflater.inflate(R.layout.v_app_menu_item, mParent, false);
        ButterKnife.bind(this, view);

        view.setOnClickListener(v -> mViewController.showFragments(data));
        mTvTitle.setText(data.getTitle());

        if (data.isSelected())
            mIvLeftImage.setImageDrawable(mViewController.getDrawableByRes(data.getIconSelectedRes()));
        else
            mIvLeftImage.setImageDrawable(mViewController.getDrawableByRes(data.getIconRes()));

        return view;
    }
}
