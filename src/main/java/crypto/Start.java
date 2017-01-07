package crypto;

import org.apache.commons.codec.digest.Crypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Start {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
//        hashIt("a");
//        System.out.println("----");
//        hashItCrypt("a");

        final String toFind = "$1$8rA0tyjz$VFDsq5LmUq.WmXLsAIMIV0";

        URL url = Start.class.getResource("/dictionary.txt");
        File file = new File(url.getFile());
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            String l;
            while ((l = inputStream.readLine()) != null) {
                String hash = hashItCrypt(l);
                System.out.println(l + " - " + hash);

                if (toFind.equals(hash)) {
                    System.out.println("FOUND!!!");
                }
            }
        }


    }

    private static void hashIt(final String str) throws NoSuchAlgorithmException {
        final String salt = "$1$8rA0tyjz$";
        if (str == null) {
            return;
        }
        final MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] b = md5.digest((salt + str).getBytes());
        System.out.println(b);
        System.out.println(new BigInteger(1, md5.digest(str.getBytes())));
        System.out.println(new BigInteger(1, md5.digest(str.getBytes())).toString(16));
        System.out.println(Base64.getEncoder().encodeToString(b));

    }

    private static String hashItCrypt(final String str) throws NoSuchAlgorithmException {
        final String salt = "$1$8rA0tyjz$";
        if (str == null) {
            return null;
        }
//        System.out.println(Crypt.crypt(str));
//        System.out.println(Crypt.crypt(str, salt));
        return Crypt.crypt(str, salt);

    }
}
