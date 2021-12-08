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

        int hour = degrees / 30;
        int minutes = degrees %10 *2;
        return hour * 100 + minutes;
    }

    public static void main(String[] args) {
        System.out.println( getTimeBasedOnDegree(180));
    }
}
