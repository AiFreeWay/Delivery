package appdoor.com.delivery.presentation.di.modules;


import java.util.List;

import javax.inject.Named;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.executors.AddOrderToCart;
import appdoor.com.delivery.domain.executors.Exit;
import appdoor.com.delivery.domain.executors.GetFoods;
import appdoor.com.delivery.domain.executors.GetMenu;
import appdoor.com.delivery.domain.executors.GetOrdered;
import appdoor.com.delivery.domain.executors.GetTable;
import appdoor.com.delivery.domain.executors.GetTableLocal;
import appdoor.com.delivery.domain.executors.PostTable;
import appdoor.com.delivery.domain.executors.PutTableLocal;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import appdoor.com.delivery.domain.models.TableDomain;
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
    public static final String GET_TABLE_KEY = "gettable";
    public static final String POST_TABLE_KEY = "posttablekey";
    public static final String GET_TABLE_LOCAL_KEY = "gettlocalk";
    public static final String PUT_TABLE_LOCAL_KEY = "pttlocalk";
    public static final String ADD_ORDER_TO_CART_KEY = "aaadordrtocrt";
    public static final String GET_ORDERED_KEY = "getordddrd";
    public static final String EXIT_KEY = "ext";

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
    public Interactor<List<MenuItemDomain>> provideGetMenu(GetMenu getMenu) {
        return getMenu;
    }

    @Provides
    @Named(GET_FOODS_KEY)
    @PerActivity
    public Interactor1<List<FoodItemDomain>, Integer> provideGetFoods(GetFoods getFoods) {
        return getFoods;
    }

    @Provides
    @Named(GET_TABLE_KEY)
    @PerActivity
    public Interactor1<TableDomain, Integer> provideGetTable(GetTable getTable) {
        return getTable;
    }

    @Provides
    @Named(POST_TABLE_KEY)
    @PerActivity
    public Interactor1<Void, Integer> providePostTable(PostTable postTable) {
        return postTable;
    }

    @Provides
    @Named(GET_TABLE_LOCAL_KEY)
    @PerActivity
    public Interactor<TableDomain> provideGetTableLocal(GetTableLocal getTableLocal) {
        return getTableLocal;
    }

    @Provides
    @Named(PUT_TABLE_LOCAL_KEY)
    @PerActivity
    public Interactor1<Void, TableDomain> providePutTableLocal(PutTableLocal putTableLocal) {
        return putTableLocal;
    }

    @Provides
    @Named(ADD_ORDER_TO_CART_KEY)
    @PerActivity
    public Interactor1<Void, FoodItemDomain> provideAddOrder(AddOrderToCart addOrderToCart) {
        return addOrderToCart;
    }

    @Provides
    @Named(GET_ORDERED_KEY)
    @PerActivity
    public Interactor<List<OrderedFoodDomain>> provideGetOrdered(GetOrdered getOrdered) {
        return getOrdered;
    }

    @Provides
    @Named(EXIT_KEY)
    @PerActivity
    public Interactor<Void> provideExit(Exit exit) {
        return exit;
    }
}
