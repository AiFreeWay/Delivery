package appdoor.com.delivery.presentation.app;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.presentation.di.components.ApplicationComponent;
import appdoor.com.delivery.presentation.di.components.DaggerApplicationComponent;
import appdoor.com.delivery.presentation.di.modules.ApplicationModule;


public class DeliveryApplication extends Application {

    public static final String UNIVERSAL_APP_ERROR_TAG = "++++";

    private ApplicationComponent mComponent;
    private OrmLiteSqlHelper mDatabaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabaseHelper = OpenHelperManager.getHelper(this, OrmLiteSqlHelper.class);
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        OpenHelperManager.releaseHelper();
    }

    public ApplicationComponent getDaggerComponent() {
        return mComponent;
    }

    public OrmLiteSqlHelper getSqlHelper() {
        return mDatabaseHelper;
    }
}
