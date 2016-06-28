package appdoor.com.delivery.presentation.adapters.view_binders;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.squareup.picasso.Picasso;

import appdoor.com.delivery.R;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.presentation.utils.RoundCornersTransformPicasso;
import appdoor.com.delivery.presentation.view_controllers.FragmentFoodsCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;


public class FoodsBinder implements AbstractBinder<FoodItemDomain> {

    private final RoundCornersTransformPicasso CIRCLE_CORNERS;
    private final String RUB = " р.";
    private final String EMPTY_LINE = "";

    @BindView(R.id.v_foods_im_image)
    ImageView mIvImage;
    @BindView(R.id.v_foods_tv_title)
    TextView mTvTitle;
    @BindView(R.id.v_foods_tv_subtitle)
    TextView mTvSubTitle;
    @BindView(R.id.v_foods_tv_description)
    TextView mTvDescription;
    @BindView(R.id.v_foods_tv_favorite)
    TextView mTvFavorite;
    @BindView(R.id.v_foods_iv_favorite)
    ImageView mIvFavorite;
    @BindView(R.id.v_foods_iv_under_line)
    ImageView mIvUnderline;

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

        final View underLine = mIvUnderline;

        Picasso.with(mParent.getContext())
                .load(data.getImage())
                .placeholder(R.drawable.food_placeholder)
                .error(R.drawable.food_placeholder)
                .transform(CIRCLE_CORNERS)
                .into(mIvImage);

        mTvTitle.setText(data.getTitle());
        mTvSubTitle.setText(data.getSubTitle()+RUB);
        mTvDescription.setText(data.getDescription());

        if (data.getLikes() > 0) {
            mTvFavorite.setVisibility(View.VISIBLE);
            mIvFavorite.setVisibility(View.VISIBLE);
            mTvFavorite.setText(data.getLikes()+EMPTY_LINE);
        } else {
            mTvFavorite.setVisibility(View.INVISIBLE);
            mIvFavorite.setVisibility(View.INVISIBLE);
        }

        view.setOnClickListener(v -> {
            mViewController.toOrder(data, underLine);
            });
        return view;
    }
}
