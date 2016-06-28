package appdoor.com.delivery.domain.executors;


import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.OrderedFoodDomain;
import rx.Observable;

public class GetOrdered implements Interactor<List<OrderedFoodDomain>> {

    private Repository mRepository;

    @Inject
    public GetOrdered(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<OrderedFoodDomain>> execute() {
        Observable.OnSubscribe<List<OrderedFoodDomain>> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getOrderedFoods());
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
