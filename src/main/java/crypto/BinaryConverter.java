package crypto;

public class BinaryConverter {

    public static String toBinaryString(final String input, final String delimiter) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .forEach(i -> {
                    sb.append(toBinaryString(i)).append(delimiter);
                });

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    public static String toBinaryString(final char ch) {
        return Integer.toBinaryString((int) ch);
    }

    public static String toBinaryString(final int value) {
        if (value < 0 || value > 256) {
            throw new IllegalArgumentException("Value " + value + " is not a byte");
        }

        String[] pads = {
                "",
                "0",
                "00",
                "000",
                "0000",
                "00000",
                "000000",
                "0000000"};
        return pads[Integer.numberOfLeadingZeros(value) - 24] + Integer.toBinaryString(value);
    }

    public static void printTestOfInt(final int value) {
        System.out.println("int: " + value + " -> " + Integer.toBinaryString(value) + ", leading zeros: " + Integer.numberOfLeadingZeros(value));
    }

    private static void printBinaryStringToByte(final String binary) {
        System.out.println("Binary: " + binary + " -> " + Byte.parseByte(binary, 2));
    }

    public static void testByte() {
        System.out.println(Byte.BYTES);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.toUnsignedInt(Byte.MIN_VALUE));
        System.out.println(Byte.toUnsignedInt(Byte.MAX_VALUE));

        System.out.println("MIN MAX");
        System.out.println(Integer.toBinaryString(Byte.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Byte.MAX_VALUE));

        System.out.println();
        System.out.println(Integer.toBinaryString(Byte.toUnsignedInt(Byte.MIN_VALUE)));
        System.out.println(Integer.toBinaryString(Byte.toUnsignedInt(Byte.MAX_VALUE)));

        System.out.println();
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));

        System.out.println("Binary testing");
        printBinaryStringToByte("0");
        printBinaryStringToByte("1");
        printBinaryStringToByte("01");
        printBinaryStringToByte("11");
        printBinaryStringToByte("01111111");
        printBinaryStringToByte("1000000");
//        printBinaryStringToByte("10000000"); 128 - not the byte
        printBinaryStringToByte("1111111");

    }

    private static void testString() {
        System.out.println(toBinaryString('a'));
        System.out.println(toBinaryString('b'));
        System.out.println(toBinaryString('c'));
        System.out.println(toBinaryString('d'));
        System.out.println(toBinaryString('e'));


        printTestOfInt(1);
        printTestOfInt(2);
        printTestOfInt(3);
        printTestOfInt(4);
        printTestOfInt(5);
        printTestOfInt(Integer.MAX_VALUE - 2);
        printTestOfInt(Integer.MAX_VALUE - 1);
        printTestOfInt(Integer.MAX_VALUE);
        printTestOfInt(Integer.MIN_VALUE);
        printTestOfInt('a');
        printTestOfInt('b');
        printTestOfInt('c');
        printTestOfInt('d');

    }

    private static void testToBinaryString() {
        System.out.println(toBinaryString("ab", " "));
        System.out.println(toBinaryString("ab cd", " "));
    }

    private static void bitsOperators() {
        byte b1 = 1;
        byte b2 = 2;

        printTestOfInt(b1);
        printTestOfInt(b2);
        System.out.println(~b1);
        System.out.println(~b2);
        System.out.println(b1 | b2);
        printTestOfInt(~b1);
        printTestOfInt(~b2);
        printTestOfInt(b1 | b2);
    }

    public static void main(String[] args) {
//        testString();
//        testByte();
//        testToBinaryString();

        bitsOperators();
    }
}
