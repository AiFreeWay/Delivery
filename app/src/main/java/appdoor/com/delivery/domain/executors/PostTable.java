package appdoor.com.delivery.domain.executors;


import java.util.UUID;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.TableDomain;
import rx.Observable;

public class PostTable implements Interactor1<Void, Integer> {

    private Repository mRepository;

    @Inject
    public PostTable(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<Void> execute(Integer data) {
        Observable.OnSubscribe<Void> subscriber = observer -> {
            try {
                TableDomain table = new TableDomain();
                table.setNumber(data);
                table.setUuid(UUID.randomUUID().toString());
                mRepository.postTable(table);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
