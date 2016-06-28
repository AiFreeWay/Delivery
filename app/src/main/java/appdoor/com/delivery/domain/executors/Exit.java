package appdoor.com.delivery.domain.executors;

import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import rx.Observable;


public class Exit implements Interactor<Void> {

    private Repository mRepository;

    @Inject
    public Exit(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Void> execute() {
        Observable.OnSubscribe<Void> subscriber = observer -> {
            try {
                mRepository.exit();
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
