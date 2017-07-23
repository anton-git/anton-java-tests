package sorttraining;

import java.util.Arrays;

public class Starter {

    private final static int[] src = {14, 2, 100, 7, 23, 63, 23, 99, 77};

    private final static int[] srcSorted = {2, 7, 14, 23, 23, 63, 77, 99, 100};

    public static void main(String[] args) {
        print(src);

        print(sortOne(src));
        print(sortTwo(src));

        print(srcSorted);
    }

    private static void print(final int[] array) {
        for (int i = 0; i < array.length; i++) {

            if (i == array.length - 1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ,");
            }

        }
    }

    private static int[] sortOne(final int[] src) {
        final int size = src.length;
        final int[] output = Arrays.copyOf(src, size);

        int tmp;
        for (int j = size - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (output[i] > output[i + 1]) {
                    tmp = output[i];
                    output[i] = output[i + 1];
                    output[i + 1] = tmp;
                }
            }
        }

        return output;
    }

    private static int[] sortTwo(final int[] src) {
        final int size = src.length;
        final int[] output = Arrays.copyOf(src, size);

        int min;
        int tmp;
        int minIndex;
        for (int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (output[j] < output[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = output[minIndex];
                output[minIndex] = output[i];
                output[i] = tmp;
            }

        }

        return output;
    }
}
