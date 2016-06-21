package appdoor.com.delivery.presentation.di.modules;


import java.util.List;

import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.executors.GetFoods;
import appdoor.com.delivery.domain.executors.GetMenu;
import appdoor.com.delivery.domain.models.FoodItem;
import appdoor.com.delivery.domain.models.MenuItem;
import appdoor.com.delivery.presentation.di.scopes.PerActivity;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.views.activities.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    public static final String GET_MENU_KEY = "getmenumategory";
    public static final String GET_FOODS_KEY = "getfoods";

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
    @Named(GET_MENU_KEY)
    @PerActivity
    public Interactor<List<MenuItem>> provideGetMenu(GetMenu getMenu) {
        return getMenu;
    }

    @Provides
    @Named(GET_FOODS_KEY)
    @PerActivity
    public Interactor1<List<FoodItem>, Integer> provideGetFoods(GetFoods getFoods) {
        return getFoods;
    }
}
