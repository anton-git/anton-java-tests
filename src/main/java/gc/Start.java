package gc;

import java.util.HashSet;
import java.util.Set;

public class Start {

    static class A {
        private String prefix;
        private int i;
        private int a;
        private String b;

        public A(String prefix, int i) {
            this.prefix = prefix;
            this.i = i;
            this.a = i * 10;
            this.b = "1234567890";
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Disposing " + prefix + " - A[" + i + "]");
        }
    }

    private static Set<A> generateObjects(String prefix, int count) {
        Set<A> set = new HashSet<>();
        int i = 0;
        while (i < count) {
            set.add(new A(prefix, i++));
        }

        return set;
    }

    private static void emulateFullGC() throws InterruptedException {
        System.out.println("Emulating Full GC by creating bunch of referenced objects");

        Set<A> set1 = generateObjects("AAA-BBB-CCC-1", 100_000_000);
        Thread.sleep(4000);
        Set<A> set2 = generateObjects("AAA-BBB-CCC-2", 100_000_000);
        Thread.sleep(4000);
        Set<A> set3 = generateObjects("AAA-BBB-CCC-3", 1_000_000);
    }

    private static void emulateSmallGC() throws InterruptedException {
        System.out.println("Generating XX");
        generateObjects("XX", 10000);
        Thread.sleep(3000);

        System.out.println("Generating AX");
        Set<A> setA = generateObjects("AX", 10000);
        Thread.sleep(3000);

        System.out.println("Generating BX");
        Set<A> setB = generateObjects("BX", 10000);
        Thread.sleep(3000);

        System.out.println("Generating CX");
        generateObjects("CX", 10000);
        Thread.sleep(3000);

        System.out.println("Generating DX");
        Set<A> setD = generateObjects("DX", 10000);
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);

        emulateFullGC();

        System.out.println("Final sleep");
        Thread.sleep(10000);
    }
}
