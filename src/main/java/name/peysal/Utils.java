package name.peysal;

/**
 * Utility or helper class which normally using static method.
 * @author peysal
 */
public class Utils {

    public static String printLogMessage(final String message) {
        String newMessage = "--" + message + "--";
        System.out.println(newMessage);
        return newMessage;
    }
}
