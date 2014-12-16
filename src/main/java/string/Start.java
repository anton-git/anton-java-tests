package string;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 25/05/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class Start {

    public static void main(String[] args) {

        String s1 = "aaaaa.eeeeee.org";
        int dotIndex = s1.lastIndexOf(".");
        SimpleDateFormat sdf = new SimpleDateFormat("-yyyy-MM-dd");
        String newString = s1.substring(0, dotIndex)
                + sdf.format(Calendar.getInstance().getTime())
                + s1.substring(dotIndex, s1.length());

        System.out.println(s1);
        System.out.println(newString);

    }

}
