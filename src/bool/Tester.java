package bool;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 05/08/13
 * Time: 23:59
 */
public class Tester {

    public static void main(String[] args) {
        show();
    }

    private static void show() {
        showOne(true, true);
        showOne(false, false);
        showOne(true, false);
        showOne(false, true);
    }

    private static void showOne(boolean a, boolean b) {
        System.out.println(" " + a + " - " + b +" = " + calc(a, b) + " dumb=" + calcSimple(a, b));
    }

    private static int calc(boolean showRetailer, boolean showSite) {
//        int result = showSite ? showRetailer ?4:5 :showRetailer?3:4;
//        int res = (showSite & showRetailer) || (!showSite & !showRetailer) ? 4 : showSite ?5 : 3;

        int res = !(showSite ^ showRetailer) ? 4 : showSite ? 5 : 3;
        return res;
    }

    private static int calcSimple(boolean showRetailer, boolean showSite) {
        int result = showSite ? 5 : 4;
        result = showRetailer ? result -1 : result;
        return result;
    }

}
