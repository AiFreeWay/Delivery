package appdoor.com.delivery.domain.executors;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.TableDomain;
import rx.Observable;


public class PutTableLocal implements Interactor1<Void, TableDomain> {

    private Repository mRepository;

    @Inject
    public PutTableLocal(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Void> execute(TableDomain data) {
        Observable.OnSubscribe<Void> subscriber = observer -> {
            try {
                mRepository.putTableLocal(data);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
