package appdoor.com.delivery.presentation.di.modules;


import appdoor.com.delivery.presentation.di.scopes.PerActivity;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.views.activities.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

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
}
