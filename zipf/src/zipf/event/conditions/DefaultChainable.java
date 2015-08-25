package zipf.event.conditions;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DefaultChainable implements Chainable, Cloneable {

    public ArrayList<Chainable> sources = new ArrayList<Chainable>();
    public ArrayList<Chainable> targets = new ArrayList<Chainable>();
    public Object item;
    public RuleItemSet parent;

    @Override
    public void addSource(Chainable chainable) {
        sources.add(chainable);
    }

    @Override
    public RuleItemSet getParent() {
        return parent;
    }

    @Override
    public void removeSource(Chainable chainable) {
        sources.remove(chainable);
    }

    @Override
    public void addTarget(Chainable chainable) {
        chainable.addSource(this);
        targets.add(chainable);
    }

    @Override
    public void removeTarget(Chainable chainable) {
        targets.remove(chainable);
    }

    @Override
    public ArrayList<Chainable> getSources() {
        return sources;
    }

    @Override
    public ArrayList<Chainable> getTargets() {
        return targets;
    }

    @Override
    public void notifyTargets(Object item) {
        for (Chainable c : targets) {
            c.set(item);
        }
    }

    @Override
    public void remove() {
        parent.removeRuleItem(this);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DefaultChainable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
