package tools;

/**
 * Tools class for testing
 *
 * @author Sergey Irupin
 * @version dated Nov 28, 2017
 */
public class Tools {

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}