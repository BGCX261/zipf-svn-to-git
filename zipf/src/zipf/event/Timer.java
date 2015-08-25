package zipf.event;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Timer {

    static String[] DayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static GregorianCalendar cal = new GregorianCalendar();
    public static int dayOfWeek;
    static String day;
    public static int week;

    public static String getDate() {
        cal.setTime(new Date());
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        day = DayNames[dayOfWeek - 1];
        week = cal.get(Calendar.WEEK_OF_YEAR);
        return day + " " + week;
    }

    public static String getName(Object o) {
        return Timer.getDate() + " - " + o.getClass().getSimpleName() + "°" + Math.random();
    }
}
