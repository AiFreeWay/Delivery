package appdoor.com.delivery.presentation.adapters.view_binders;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.models.MenuItem;
import appdoor.com.delivery.presentation.view_controllers.ActivityMainController;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuBinder implements AbstractBinder<MenuItem> {

    @BindView(R.id.v_menu_item_iv_left_image)
    ImageView mIvLeftImage;
    @BindView(R.id.v_menu_item_tv_title)
    TextView mTvTitle;

    private ActivityMainController mViewController;

    public MenuBinder(ActivityMainController controller) {
        mViewController = controller;
    }

    @Override
    public View bind(View view, MenuItem data) {
        ButterKnife.bind(this, view);
        mIvLeftImage.setImageDrawable(mViewController.getDrawableByRes(data.getIconRes()));
        mTvTitle.setText(data.getTitle());
        return view;
    }
}
