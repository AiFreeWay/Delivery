package appdoor.com.delivery.presentation.views.activities;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import appdoor.com.delivery.R;
import appdoor.com.delivery.presentation.adapters.MultyAdapter;
import appdoor.com.delivery.presentation.adapters.view_binders.AppMenuBinder;
import appdoor.com.delivery.presentation.di.components.ActivityComponent;
import appdoor.com.delivery.presentation.di.components.DaggerActivityComponent;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.models.AppMenuItem;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.utils.ToolbarDrawerToogle;
import appdoor.com.delivery.presentation.view_controllers.ActivityMainCtrl;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static final String MENU_ITEM_KEY = "menuitemkkk";
    public final String ORDERED_TITLE = "ЗАКАЗАНО: ";

    @BindView(R.id.ac_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ac_main_dl_menu)
    DrawerLayout mDlMenu;
    @BindView(R.id.ac_main_lv_menu)
    ListView mLvMenu;
    @BindView(R.id.spinner_nav)
    TextView mTvOrderedTitle;

    private ActivityComponent mComponent;
    private ActionBarDrawerToggle mDrawerToggle;
    private MultyAdapter<AppMenuItem> mAdapter;
    private ActivityMainCtrl mViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        ButterKnife.bind(this);
        initToolbar();
        initDI();
        mViewController = new ActivityMainCtrl(this);
        mAdapter = new MultyAdapter<AppMenuItem>(new AppMenuBinder(mViewController));
        mLvMenu.setAdapter(mAdapter);
        mLvMenu.addHeaderView(getHeaderView());
        mTvOrderedTitle.setOnClickListener(v -> mViewController.showFragmentsFromMenu(MenuFactory.MenuItems.ORDERED));
        hideOrderTitle();
        mViewController.start(savedInstanceState);
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
            mViewController.popBack();
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
                .applicationComponent(getDeliveryApplication().getDaggerComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    private View getHeaderView() {
        return mViewController.getLayoutInflater().inflate(R.layout.v_header_menu, mLvMenu, false);
    }

    public void closeMenu() {
        mDlMenu.closeDrawer(Gravity.LEFT);
    }

    public void hideOrderTitle() {
        mTvOrderedTitle.setVisibility(View.INVISIBLE);
    }

    public void showOrderTitle(int foodsCount) {
        mTvOrderedTitle.setVisibility(View.VISIBLE);
        mTvOrderedTitle.setText(ORDERED_TITLE + foodsCount);
    }

    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }

    public ListView getLvMenu() {
        return mLvMenu;
    }

    public MultyAdapter<AppMenuItem> getAdapter() {
        return mAdapter;
    }

    public ActivityMainCtrl getViewController() {
        return mViewController;
    }
}
