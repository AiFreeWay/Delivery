package appdoor.com.delivery.domain.executors;


import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.Table;
import rx.Observable;

public class GetTable implements Interactor1<Table, Integer> {

    private Repository mRepository;

    @Inject
    public GetTable(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Table> execute(Integer data) {
        Observable.OnSubscribe<Table> subscriber = observer -> {
            try {
                observer.onNext(mRepository.getTable(data));
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
