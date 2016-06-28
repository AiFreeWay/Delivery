package appdoor.com.delivery.domain.executors;


import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.TableDomain;
import rx.Observable;

public class GetTable implements Interactor1<TableDomain, Integer> {

    private Repository mRepository;

    @Inject
    public GetTable(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<TableDomain> execute(Integer data) {
        Observable.OnSubscribe<TableDomain> subscriber = observer -> {
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
