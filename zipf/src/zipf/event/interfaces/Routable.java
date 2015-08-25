package zipf.event.interfaces;

import java.lang.reflect.Member;
import zipf.event.conditions.DefaultRouter;
import zipf.event.conditions.Chainable;


public interface Routable {

    public DefaultRouter getRouter();


}
