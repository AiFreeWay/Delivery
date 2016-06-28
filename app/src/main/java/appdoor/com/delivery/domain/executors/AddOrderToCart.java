package appdoor.com.delivery.domain.executors;


import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import rx.Observable;

public class AddOrderToCart implements Interactor1<Void, FoodItemDomain> {

    private Repository mRepository;

    @Inject
    public AddOrderToCart(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Void> execute(FoodItemDomain data) {
        Observable.OnSubscribe<Void> subscriber = observer -> {
            try {
                OrderedFoodDomain orderedFood = new OrderedFoodDomain();
                orderedFood.setFood(data);
                orderedFood.setStatus(OrderedFoodDomain.STATUS_WAIT);
                mRepository.addOrderedtoCart(orderedFood);
                observer.onNext(null);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
