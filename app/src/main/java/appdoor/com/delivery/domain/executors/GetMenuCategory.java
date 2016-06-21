package appdoor.com.delivery.domain.executors;


import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.MenuCategory;
import rx.Observable;


public class GetMenuCategory implements Interactor<List<MenuCategory>> {

    private Repository mRepository;

    @Inject
    public GetMenuCategory(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<MenuCategory>> execute() {
        Observable.OnSubscribe<List<MenuCategory>> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getFoodMenu());
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
