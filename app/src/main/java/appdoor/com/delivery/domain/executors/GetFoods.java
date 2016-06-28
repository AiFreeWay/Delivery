package appdoor.com.delivery.domain.executors;

import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItemDomain;
import rx.Observable;


public class GetFoods implements Interactor1<List<FoodItemDomain>, Integer> {

    private Repository mRepository;

    @Inject
    public GetFoods(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<FoodItemDomain>> execute(Integer data) {
        Observable.OnSubscribe<List<FoodItemDomain>> subscriber = observer -> {
            try {
                List<FoodItemDomain> foods = mRepository.getFoods(data);
                mRepository.cacheFoods(foods);
                observer.onNext(foods);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
