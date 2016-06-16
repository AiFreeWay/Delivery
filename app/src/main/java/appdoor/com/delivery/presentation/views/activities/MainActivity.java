package appdoor.com.delivery.presentation.views.activities;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ListView;

import javax.inject.Inject;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.adapters.MultyAdapter;
import appdoor.com.delivery.presentation.adapters.view_binders.MenuBinder;
import appdoor.com.delivery.presentation.di.components.ActivityComponent;
import appdoor.com.delivery.presentation.di.components.DaggerActivityComponent;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.models.MenuItem;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.utils.ToolbarDrawerToogle;
import appdoor.com.delivery.presentation.view_controllers.ActivityMainController;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Inject
    FragmentsFactory mFragmentFactory;
    @Inject
    FragmentRouter mRouter;
    @Inject
    MenuFactory mMenuFactory;

    @BindView(R.id.ac_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ac_main_dl_menu)
    DrawerLayout mDlMenu;
    @BindView(R.id.ac_main_lv_menu)
    ListView mLvMenu;

    private ActivityComponent mComponent;
    private ActionBarDrawerToggle mDrawerToggle;
    private MultyAdapter<MenuItem> mAdapter;
    private ActivityMainController mViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);
        initToolbar();
        initDI();
        mViewController = new ActivityMainController(this);
        mAdapter = new MultyAdapter<MenuItem>(new MenuBinder(mViewController), mViewController.getLayoutInflater());
        mLvMenu.setAdapter(mAdapter);
        mAdapter.loadData(mMenuFactory.getMenuItems());
        mRouter.show(mFragmentFactory.getFragment(FragmentsFactory.Fragments.ENTRANCE));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            mRouter.back();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }

    @Override
    public int getFragmentViewId() {
        return R.id.ac_main_fl_fragments;
    }

    @Override
    public ActivityComponent getComponent() {
        return mComponent;
    }

    private void initToolbar() {
        mDrawerToggle = new ToolbarDrawerToogle(this, mDlMenu, mToolbar, R.string.app_name, R.string.ok);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDlMenu.addDrawerListener(mDrawerToggle);
        mToolbar.setTitle(R.string.app_name);
    }

    private void initDI() {
        mComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        mComponent.inject(this);
    }

    public ListView getLvMenu() {
        return mLvMenu;
    }
}
