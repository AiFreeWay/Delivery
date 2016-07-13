package appdoor.com.delivery.presentation.adapters.view_binders;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.presentation.utils.RoundCornersTransformPicasso;
import appdoor.com.delivery.presentation.view_controllers.FragmentOrderedCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;


public class OrderedBinder implements AbstractBinder<OrderedFoodDomain> {

    private final RoundCornersTransformPicasso CIRCLE_CORNERS;
    private final String RUB = " р.";
    private final String EMPTY_LINE = "";

    @BindView(R.id.v_ordered_im_image)
    ImageView mIvImage;
    @BindView(R.id.v_ordered_tv_title)
    TextView mTvTitle;
    @BindView(R.id.v_ordered_tv_subtitle)
    TextView mTvSubTitle;
    @BindView(R.id.v_ordered_tv_description)
    TextView mTvDescription;
    
    private FragmentOrderedCtrl mViewController;
    private ListView mParent;
    private LayoutInflater mLayoutInflater;

    public OrderedBinder(FragmentOrderedCtrl controller) {
        CIRCLE_CORNERS = new RoundCornersTransformPicasso();
        mViewController = controller;
        mParent = mViewController.getFragment().getLvMain();
        mLayoutInflater = mViewController.getLayoutInflater();
    }

    @Override
    public View bind(View view, OrderedFoodDomain data) {
        if (view == null)
            view = mLayoutInflater.inflate(R.layout.v_ordered, mParent, false);
        ButterKnife.bind(this, view);

        FoodItemDomain food = data.getFood();
        Picasso.with(mParent.getContext())
                .load(food.getImage())
                .placeholder(R.drawable.food_placeholder)
                .error(R.drawable.food_placeholder)
                .transform(CIRCLE_CORNERS)
                .into(mIvImage);

        mTvTitle.setText(food.getTitle());
        mTvSubTitle.setText(food.getSubTitle()+RUB);
        mTvDescription.setText(food.getDescription());
        return view;
    }
}
