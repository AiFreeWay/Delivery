package appdoor.com.delivery.presentation.adapters.view_binders;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.presentation.utils.RoundCornersTransformPicasso;
import appdoor.com.delivery.presentation.view_controllers.FragmentFoodsCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FoodsBinder implements AbstractBinder<FoodItemDomain> {

    private final RoundCornersTransformPicasso CIRCLE_CORNERS;

    @BindView(R.id.v_foods_im_image)
    ImageView mIvImage;
    @BindView(R.id.v_foods_tv_title)
    TextView mTvTitle;
    @BindView(R.id.v_foods_tv_subtitle)
    TextView mTvSubTitle;
    @BindView(R.id.v_foods_tv_description)
    TextView mTvDescription;

    private FragmentFoodsCtrl mViewController;
    private ListView mParent;
    private LayoutInflater mLayoutInflater;

    public FoodsBinder(FragmentFoodsCtrl controller) {
        CIRCLE_CORNERS = new RoundCornersTransformPicasso();
        mViewController = controller;
        mParent = mViewController.getFragment().getLvMain();
        mLayoutInflater = mViewController.getLayoutInflater();
    }

    @Override
    public View bind(View view, FoodItemDomain data) {
        if (view == null)
            view = mLayoutInflater.inflate(R.layout.v_foods, mParent, false);
        ButterKnife.bind(this, view);

        Picasso.with(mParent.getContext())
                .load(data.getImage())
                .placeholder(R.drawable.food_placeholder)
                .error(R.drawable.food_placeholder)
                .transform(CIRCLE_CORNERS)
                .into(mIvImage);

        mTvTitle.setText(data.getTitle());
        mTvSubTitle.setText(data.getSubTitle()+" р.");
        mTvDescription.setText(data.getDescription());
        view.setOnClickListener(v -> mViewController.toOrder(data));
        return view;
    }
}
