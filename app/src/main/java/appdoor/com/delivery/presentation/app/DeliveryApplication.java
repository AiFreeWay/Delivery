package appdoor.com.delivery.presentation.app;

import android.app.Application;

import appdoor.com.delivery.presentation.di.components.ApplicationComponent;
import appdoor.com.delivery.presentation.di.components.DaggerApplicationComponent;
import appdoor.com.delivery.presentation.di.modules.ApplicationModule;


public class DeliveryApplication extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getDaggerComponent() {
        return mComponent;
    }
}
