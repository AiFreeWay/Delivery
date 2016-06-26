package appdoor.com.delivery.presentation.adapters.view_binders;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.presentation.utils.RoundCornersTransformPicasso;
import appdoor.com.delivery.presentation.view_controllers.FragmentMenuCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuBinder implements AbstractBinder<MenuItem> {

    private final RoundCornersTransformPicasso CIRCLE_CORNERS;
    private final String IN_MENU = "В меню: ";

    @BindView(R.id.v_menu_im_image)
    ImageView mIvImage;
    @BindView(R.id.v_menu_tv_title)
    TextView mTvTitle;
    @BindView(R.id.v_menu_tv_subtitle)
    TextView mTvSubTitle;
    @BindView(R.id.v_menu_tv_description)
    TextView mTvDescription;


    private FragmentMenuCtrl mViewController;
    private ListView mParent;
    private LayoutInflater mLayoutInflater;

    public MenuBinder(FragmentMenuCtrl controller) {
        CIRCLE_CORNERS = new RoundCornersTransformPicasso();
        mViewController = controller;
        mParent = mViewController.getFragment().getLvMain();
        mLayoutInflater = mViewController.getLayoutInflater();
    }

    @Override
    public View bind(View view, MenuItem data) {
        if (view == null)
            view = mLayoutInflater.inflate(R.layout.v_menu, mParent, false);
        ButterKnife.bind(this, view);

        Picasso.with(mParent.getContext())
                .load(data.getImage())
                .placeholder(R.drawable.food_placeholder)
                .error(R.drawable.food_placeholder)
                .transform(CIRCLE_CORNERS)
                .into(mIvImage);

        mTvTitle.setText(data.getTitle());
        mTvSubTitle.setText(IN_MENU+data.getSubTitle());
        mTvDescription.setText(data.getDescription());

        view.setOnClickListener(v -> mViewController.showFragment(data));
        return view;
    }
}
