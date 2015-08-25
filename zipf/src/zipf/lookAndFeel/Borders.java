package zipf.lookAndFeel;

import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public interface Borders {

    public static LineBorder BUTTON_STANDARD = new javax.swing.border.LineBorder(Colors.CONDITION_BORDER, 1, true);
    public static LineBorder BUTTON_STANDARD_2 = new javax.swing.border.LineBorder(Colors.CONDITION_MEDIUM_BACKGORUND, 1, true);
    public static LineBorder ROUND_ONE = new javax.swing.border.LineBorder(Colors.CONDITION_BORDER, 1, true);
    public static LineBorder VOLUME_VIS = new javax.swing.border.LineBorder(Colors.DARK_BORDER, 1, true);
    public static Border LIGHT_BIG = new javax.swing.border.LineBorder(Colors.GRAY, 2, true);
    public static Border SHADE_BIG = new javax.swing.border.LineBorder(Colors.SHADE_GRAY, 3, true);
    public static Border LIGHT_FIVE = new javax.swing.border.LineBorder(Colors.GRAY, 5, true);
    public static Border PHANTOM= new javax.swing.border.LineBorder(Colors.CONDITION_LIGHT_BACKGORUND, 1, true);
    public static Border LIGHT=new CustomButtonUI(20,1,Colors.DARK,Colors.CONDITION_LIGHT_BACKGORUND);
    public static Border TREE_BORDER = new CustomButtonUI(4);
    public static Border BUTTON_ROUND = new CustomButtonUI(10);
//    public static LineBorder BUTTON_STANDARD = new javax.swing.border.LineBorder(Colors.CONDITION_BORDER, 2, true);
//    public static LineBorder ROUND_ONE = new javax.swing.border.LineBorder(Colors.CONDITION_BORDER, 1, true);
}
