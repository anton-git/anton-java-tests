package kata.wordwrap;

public class Starter {

    public static void main(String[] args) {

    }


    static String wrap(final String input, final int columnLength) {

        if (input.length() <= columnLength) {
            return input;
        }

        int space = input.substring(0, columnLength).lastIndexOf(' ');

        if (space != -1) {
            return input.substring(0, space) + "\n" + wrap(input.substring(space + 1), columnLength);
        }

        if (input.charAt(columnLength) == ' ') {
            return input.substring(0, columnLength) + "\n" + wrap(input.substring(columnLength + 1), columnLength);
        }

        return input.substring(0, columnLength) + "\n" + wrap(input.substring(columnLength), columnLength);
    }


    /*
    * if (input.length() <= columnLength) {
            return input;
        }

        StringBuilder builder = new StringBuilder();
        System.out.println(input.length()/columnLength);
        for (int i = 0; i < input.length()/columnLength; i+= columnLength) {
            System.out.println(i);
            builder.append(input.substring(i, Math.min(i + columnLength, input.length()))).append("\n");
        }

        return builder.toString();
    *
    * */
}
