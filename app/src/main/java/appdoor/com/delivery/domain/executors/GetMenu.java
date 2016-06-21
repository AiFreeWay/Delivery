package appdoor.com.delivery.domain.executors;


import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.MenuItem;
import rx.Observable;


public class GetMenu implements Interactor<List<MenuItem>> {

    private Repository mRepository;

    @Inject
    public GetMenu(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<MenuItem>> execute() {
        Observable.OnSubscribe<List<MenuItem>> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getMenu());
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
