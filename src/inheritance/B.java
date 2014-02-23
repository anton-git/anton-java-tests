package inheritance;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 16/07/13
 * Time: 19:46
 */
public class B extends A {

    public void show() {
        super.show();
        System.out.println("Hello from B.");
    }
}
