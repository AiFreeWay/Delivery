package appdoor.com.delivery.presentation.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import appdoor.com.delivery.data.repositories.RepositoryImpl;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private DeliveryApplication mApplication;

    public ApplicationModule(DeliveryApplication deliveryApplication) {
        mApplication = deliveryApplication;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    public DeliveryApplication getApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }
}
