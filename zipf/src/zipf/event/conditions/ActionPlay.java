package zipf.event.conditions;

import java.lang.reflect.Method;
import zipf.event.interfaces.Playable;

public class ActionPlay extends DefaultAction {



    @Override
    public void process() {
        ((Playable)item).play();
    }




    
}
