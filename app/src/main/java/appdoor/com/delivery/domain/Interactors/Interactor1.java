package appdoor.com.delivery.domain.Interactors;

import rx.Observable;


public interface Interactor1<O, I> {

    Observable<O> execute(I data);
}