package zipf.GUI.vis;

public class VisHelper {

    public static int getEventY(int i) {
        float f = i * 60f / 127f;
        return (int) f;
    }

    public static int getVisY(int y) {
        float f = Math.abs(127 - (y * 127f / 60f));
        return (int) f;
    }
}
