package brainfuck;

public class ChangeAB {

    private static int a = 7;
    private static int b = 8;

    public static void main(String[] args) {
        logAB(a, b);
        swapAB();
        logAB(a, b);
    }

    private static void swapAB() {
        //ok with sum but sum may exceed int type
//        a = a + b;
//        b = a - b;
//        a = a - b;

        //ok!
        a = a - b;
        b = b + a;
        a = b - a;//a = (b + a - b) - a + b
    }

    private static void logAB(int a, int b) {
        System.out.println("a = " + a + "  b = " + b);
    }

}
