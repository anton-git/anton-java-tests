package io;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 07/04/13
 * Time: 01:52
 * To change this template use File | Settings | File Templates.
 */
public class Start {
    private static final String INPUT_FILE_NAME = "resources\\in.txt";
    private static final String OUT_FILE_NAME_1 = "resources\\out1.txt";
    private static final String OUT_FILE_NAME_2 = "resources\\out2.txt";
    private static final String OUT_FILE_NAME_3 = "resources\\out3.txt";

    public static void main(String[] args) {
        try {
//            readUsingByteStream();
//            readUsingCharacterStream();
            readUsingBufferAndPrintLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readUsingBufferAndPrintLines() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            outputStream = new PrintWriter(new FileWriter(OUT_FILE_NAME_3));

            String l;
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private static void readUsingCharacterStream() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(INPUT_FILE_NAME);
            outputStream = new FileWriter(OUT_FILE_NAME_2);

            int c;//uses 16 bits as UNICODE
            while ((c = inputStream.read()) != -1) {
                System.out.println(c);
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /*
        Using bytes streams - It's like low level IO
     */
    private static void readUsingByteStream() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(INPUT_FILE_NAME);
            out = new FileOutputStream(OUT_FILE_NAME_1);
            int c;//uses 8 bits as BYTE stream, int type for supporting -1 value

            while ((c = in.read()) != -1) {
                System.out.println(c);
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
