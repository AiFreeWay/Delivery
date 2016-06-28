package appdoor.com.delivery.presentation.di.components;

import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.di.scopes.PerActivity;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.view_controllers.ActivityMainCtrl;
import appdoor.com.delivery.presentation.view_controllers.FragmentEntranceCtrl;
import appdoor.com.delivery.presentation.view_controllers.FragmentFoodsCtrl;
import appdoor.com.delivery.presentation.view_controllers.FragmentMenuCtrl;
import appdoor.com.delivery.presentation.view_controllers.FragmentOrderedCtrl;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(ActivityMainCtrl controller);
    void inject(FragmentMenuCtrl controller);
    void inject(FragmentFoodsCtrl controller);
    void inject(FragmentEntranceCtrl controller);
    void inject(FragmentOrderedCtrl controller);

    FragmentRouter provideFragmentRouter();
    FragmentsFactory provideFragmentsFactory();
    MenuFactory provideMenuFactory();
}
