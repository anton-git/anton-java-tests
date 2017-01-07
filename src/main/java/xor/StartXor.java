package xor;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class StartXor {

    public static void main(String[] args) {

//        char2binary('j');
//        char2binary('#');
//        char2binary('I');
//        char2binary('w');
//        char2binary('O');
//        char2binary('r');

//        BitSet bitSet = BitSet.valueOf("abc".getBytes());
//        System.out.println(bitSet.);


//        charXorChar('a', 'c');

        int binary1 = 0B01010010;
        int key = 0B01001001;
//        charFromInt(binary1 ^ key);


        solve();


    }

    private static String string2binary(final String input) {
        byte[] bytes = input.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            System.out.println(b);
            stringBuilder.append(Integer.toBinaryString(b)).append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static String char2binary(final char c) {
        System.out.println(c);
//        System.out.println((int) c);
        System.out.println(Integer.toBinaryString((int) c));
        return Integer.toBinaryString((int) c);
    }

    private static String charXorChar(char ch, char key) {
        System.out.print("Char: " + ch);
        System.out.println(" binary: " + Integer.toBinaryString((int) ch));
        System.out.print("Key : " + key);
        System.out.println(" binary: " + Integer.toBinaryString((int) key));
        System.out.println("XOR: " + (ch ^ key));
        System.out.println(Integer.toBinaryString(ch ^ key));
        BitSet bs = new BitSet(ch);
//        System.out.println(bs.);
//        BitSet bs2 = new BitSet(key);
//        bs.xor(bs2);
        return "";
    }

    private static char charFromInt(int a) {
        System.out.println("-= charFromInt =-");
        System.out.println("int  : " + a);
        System.out.println("char : " + (char) a);
        return (char) a;
    }


    private static void solve() {
        final String src = "01100110 01100110 01100110 01100110 01100110 01100110";
        final String binaryString = src.replaceAll(" ", "");

//        final String key = "IwOr";
        final String key = "qw8J";

        final List<Integer> integers = new ArrayList<>();
        int step = 0;
        while (step < binaryString.length()) {
            integers.add(Integer.parseInt(binaryString.substring(step, step + 8), 2));
            step += 8;
        }
        System.out.println(integers);


        //{"showpassword":"no","bgcolor":"#ffffff"}@
        //xor
        final List<Integer> xoredIntegers = new ArrayList<>();
        byte b = 0;
        for (Integer i : integers) {
            xoredIntegers.add(i ^ (key.charAt(b % key.length())));
        }

        System.out.println(xoredIntegers);

        xoredIntegers.stream().forEach(i -> System.out.print((char) (int) i));
        System.out.println();
        xoredIntegers.stream().forEach(i -> System.out.print(Integer.toBinaryString(i)));


    }
}
