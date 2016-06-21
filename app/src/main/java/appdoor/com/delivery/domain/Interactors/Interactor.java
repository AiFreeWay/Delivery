package appdoor.com.delivery.domain.Interactors;


import java.util.List;

import appdoor.com.delivery.domain.models.MenuCategory;
import rx.Observable;

public interface Interactor<O> {

    Observable<O> execute();
}
