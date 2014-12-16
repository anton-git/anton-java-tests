package inheritance;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 16/07/13
 * Time: 19:46
 */
public class A {
    public static void main(String[] args) {
        B b = new B();
        b.show();
    }

    public void show() {
        System.out.println("Hello from A.");
    }
}
