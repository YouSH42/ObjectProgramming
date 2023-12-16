package Cipher;

import java.io.*;

public class App {
    private static final String INPUT_FILE_PATH = "/Users/sanghyun/Develop/java/week9/day1/src/Cipher/input.txt";
    private static final String ENCODED_FILE_PATH = "/Users/sanghyun/Develop/java/week9/day1/src/Cipher/enc.txt";
    private static final String RECOVERED_FILE_PATH = "/Users/sanghyun/Develop/java/week9/day1/src/Cipher/recover.txt";

    public static void main(String[] args) {
        encodeAndDecodeFile();
        compareFiles();
    }

    private static void encodeAndDecodeFile() {
        try (FileReader fin = new FileReader(INPUT_FILE_PATH);
             FileWriter fout = new FileWriter(ENCODED_FILE_PATH)) {

            int c;
            while ((c = fin.read()) != -1) {
                fout.write(c + 1);
            }
            System.out.println("Encode Success");

            // Decode the encoded file
            try (FileReader encodedFin = new FileReader(ENCODED_FILE_PATH);
                 FileWriter recoverFout = new FileWriter(RECOVERED_FILE_PATH)) {

                while ((c = encodedFin.read()) != -1) {
                    recoverFout.write(c - 1);
                }
                System.out.println("Decode Success");

            } catch (IOException e) {
                System.out.println("Decoding error");
            }

        } catch (IOException e) {
            System.out.println("Encoding error");
        }
    }

    private static void compareFiles() {
        try (FileReader originalFin = new FileReader(INPUT_FILE_PATH);
             FileReader recoveredFin = new FileReader(RECOVERED_FILE_PATH)) {

            int c1, c2;
            while ((c1 = originalFin.read()) != -1 && (c2 = recoveredFin.read()) != -1) {
                if (c1 != c2) {
                    System.out.println("Files are different!");
                    return;
                }
            }
            System.out.println("Files are identical!");

        } catch (IOException e) {
            System.out.println("File comparison error");
        }
    }
}
