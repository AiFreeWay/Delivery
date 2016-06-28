package appdoor.com.delivery.domain.Interactors;


import rx.Observable;

public interface Interactor<O> {

    Observable<O> execute();
}
