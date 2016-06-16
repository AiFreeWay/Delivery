package appdoor.com.delivery.presentation.di.components;

import appdoor.com.delivery.presentation.di.modules.ActivityModule;
import appdoor.com.delivery.presentation.di.scopes.PerActivity;
import appdoor.com.delivery.presentation.utils.FragmentRouter;
import appdoor.com.delivery.presentation.utils.FragmentsFactory;
import appdoor.com.delivery.presentation.utils.MenuFactory;
import appdoor.com.delivery.presentation.views.activities.MainActivity;
import dagger.Component;

@PerActivity
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

    FragmentRouter provideFragmentRouter();
    FragmentsFactory provideFragmentsFactory();
    MenuFactory provideMenuFactory();
}
