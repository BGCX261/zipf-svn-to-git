package zipf.event.interfaces;

import java.io.Serializable;
import javax.sound.midi.Receiver;

public interface Element extends Serializable, Identifier {

    // counter and statistics
    void setY(int i);

    int getY();

    void setPosition(long i);

    long getPosition();

    public void remove();

    public EventContainer getParent();

    public void setParent(EventContainer eCon);

    public void updateY();

    Receiver getReceiver();
}
