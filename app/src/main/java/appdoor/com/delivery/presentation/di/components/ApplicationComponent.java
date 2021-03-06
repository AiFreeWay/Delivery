package appdoor.com.delivery.presentation.di.components;


import android.content.Context;

import javax.inject.Singleton;

import appdoor.com.delivery.data.orm.OrmLiteSqlHelper;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.presentation.app.DeliveryApplication;
import appdoor.com.delivery.presentation.di.modules.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context provideContext();
    DeliveryApplication provideApplication();
    Repository provideRepository();
    OrmLiteSqlHelper provideOrmLiteSqlHelper();
}
