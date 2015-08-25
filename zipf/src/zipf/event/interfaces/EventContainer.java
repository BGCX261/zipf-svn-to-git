package zipf.event.interfaces;

import zipf.event.Event;

public interface EventContainer extends Element{

    void addEvent(Event event);

    void removeEvent(Event event);

}
