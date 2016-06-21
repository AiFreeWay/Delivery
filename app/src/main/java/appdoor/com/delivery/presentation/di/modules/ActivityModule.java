package appdoor.com.delivery.presentation.di.modules;


import java.util.List;

import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.executors.GetMenuCategory;
import appdoor.com.delivery.domain.models.MenuCategory;
import appdoor.com.delivery.presentation.di.scopes.PerActivity;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.views.activities.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    public static final String GET_MENU_CATEGORY = "getmenumategory";

    private BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    public FragmentRouter getRouter() {
        return new FragmentRouter(mActivity.getFragmentViewId(), mActivity.getSupportFragmentManager());
    }

    @Provides
    @PerActivity
    public FragmentsFactory getFragmentsFactory() {
        return new FragmentsFactory();
    }

    @Provides
    @PerActivity
    public MenuFactory getMenuFactory() {
        return new MenuFactory();
    }

    @Provides
    @Named(GET_MENU_CATEGORY)
    @PerActivity
    public Interactor<List<MenuCategory>> provideGetMenuCategory(GetMenuCategory getMenuCategory) {
        return getMenuCategory;
    }
}
