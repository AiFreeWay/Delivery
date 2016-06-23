package appdoor.com.delivery.domain.executors;


import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import rx.Observable;

public class GetTableLocal implements Interactor<Integer> {

    private Repository mRepository;

    @Inject
    public GetTableLocal(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Integer> execute() {
        Observable.OnSubscribe<Integer> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getTableLocal());
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}