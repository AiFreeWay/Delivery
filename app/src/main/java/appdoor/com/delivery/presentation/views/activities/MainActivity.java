package appdoor.com.delivery.presentation.views.activities;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import javax.inject.Inject;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.di.components.ActivityComponent;
import appdoor.com.delivery.presentation.di.components.DaggerActivityComponent;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.views.fragments.MainFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Inject
    FragmentsFactory mFactory;
    @Inject
    FragmentRouter mRouter;
    @BindView(R.id.ac_main_toolbar)
    Toolbar mToolbar;

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);
        mToolbar.setTitle(R.string.app_name);
        initDI();
        mRouter.show(mFactory.getFragment(FragmentsFactory.Fragments.MAIN));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            mRouter.back();
        return true;
    }

    @Override
    public int getFragmentViewId() {
        return R.id.ac_main_fl_fragments;
    }

    @Override
    public ActivityComponent getComponent() {
        return mComponent;
    }

    private void initDI() {
        mComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        mComponent.inject(this);
    }
}
