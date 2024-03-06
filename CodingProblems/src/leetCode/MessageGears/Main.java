package leetCode.MessageGears;

/**
 * Given an input in degrees of the current angle of the hour hand, return to me the current time.
 *
 *  allow negative
 *  over 360
 *  0 - midnight
 *  361
 *  180
 */
public class Main {
    public static int getTimeBasedOnDegree(int degrees){
        // 360 / 12 is 30
        int hour = degrees / 30;
        // every hour has 30 degrees, so 1 degree for every 2 minutes
        int minutes = degrees %10 *2;
        return hour * 100 + minutes;
    }

    public static void main(String[] args) {
        System.out.println(getTimeBasedOnDegree(180));
    }
}
