package appdoor.com.delivery.domain.executors;

import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.FoodItem;
import rx.Observable;


public class GetFoods implements Interactor1<List<FoodItem>, Integer> {

    private Repository mRepository;

    @Inject
    public GetFoods(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<FoodItem>> execute(Integer data) {
        Observable.OnSubscribe<List<FoodItem>> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getFoods(data));
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
