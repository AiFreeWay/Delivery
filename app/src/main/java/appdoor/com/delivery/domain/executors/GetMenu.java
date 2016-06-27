package appdoor.com.delivery.domain.executors;

import java.util.List;

import javax.inject.Inject;

import appdoor.com.delivery.domain.Interactors.Interactor;
import appdoor.com.delivery.domain.interfaces.Repository;
import appdoor.com.delivery.domain.models.MenuItemDomain;
import rx.Observable;


public class GetMenu implements Interactor<List<MenuItemDomain>> {

    private Repository mRepository;

    @Inject
    public GetMenu(Repository repository) {
        mRepository = repository;
    }

    @Override
    public Observable<List<MenuItemDomain>> execute() {
        Observable.OnSubscribe<List<MenuItemDomain>> subscriber = observer -> {
            try {
                List<MenuItemDomain> menu = mRepository.getMenu();
                mRepository.cacheMenu(menu);
                observer.onNext(menu);
            } catch (Exception e) {
                observer.onError(e);
            }
            observer.onCompleted();
        };
        return Observable.create(subscriber);
    }
}
