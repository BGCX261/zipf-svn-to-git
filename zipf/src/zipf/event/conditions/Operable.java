// <editor-fold defaultstate="collapsed" desc="...">
package zipf.event.conditions;

// </editor-fold>
import java.lang.reflect.Method;


public interface Operable {

    final int NONE = 3;
    final int AND = 0;
    final int OR = 1;
    final int XOR = 2;


    int getOperator();

    void setOperator(int operator);
}
