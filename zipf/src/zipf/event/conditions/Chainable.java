package zipf.event.conditions;

import java.io.Serializable;
import java.util.ArrayList;

public interface Chainable extends Serializable {

    void set(Object item);

    void addSource(Chainable chainable);

    void removeSource(Chainable chainable);

    void addTarget(Chainable chainable);

    void removeTarget(Chainable chainable);

    ArrayList<Chainable> getSources();

    ArrayList<Chainable> getTargets();

    void notifyTargets(Object item);

    RuleItemSet getParent();

    void remove();
}
