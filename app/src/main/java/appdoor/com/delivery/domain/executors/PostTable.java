package appdoor.com.delivery.domain.executors;


import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor1;
import appdoor.com.delivery.domain.interfaces.Repository;
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
                mRepository.postTable(data);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
