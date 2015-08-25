package zipf.event.conditions;

import zipf.event.Event;

public class RouterEvent<GenEvent extends Event> extends DefaultRouter {

    public RouterEvent(String string) {
        super(string);
    }
}
