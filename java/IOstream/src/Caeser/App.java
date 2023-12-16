package Caeser;

import java.io.*;

class FileManager{
    private String INPUT_FILE_PATH = "/Users/sanghyun/Develop/java/IOstream/src/Caeser/input.txt";
    private String ENCODED_FILE_PATH = "/Users/sanghyun/Develop/java/IOstream/src/Caeser/enc.txt";
    private String RECOVERED_FILE_PATH = "/Users/sanghyun/Develop/java/IOstream/src/Caeser/recover.txt";
    private String password = "PASSWORD";
    private int SHIFT = 3;

    public void encodeAndDecodeFile() throws IOException{
        FileReader fin = new FileReader(INPUT_FILE_PATH);
        FileWriter fout = new FileWriter(ENCODED_FILE_PATH);
        int c;
        System.out.print("Input Value: ");
        while ((c = fin.read()) != -1) {
            System.out.print(((char) c));
            fout.write(encrypt((char) c));
        }
        System.out.println("");
        System.out.println("Encode Success");
        fout.close();
        fin.close();

        FileReader encodedFin = new FileReader(ENCODED_FILE_PATH);
        FileWriter recoverFout = new FileWriter(RECOVERED_FILE_PATH);

        System.out.print("Decode Value: ");
        while ((c = encodedFin.read()) != -1) {
            System.out.print(((char) c));
            recoverFout.write(decrypt((char) c));
        }
        System.out.println("");
        System.out.println("Decode Success");
        recoverFout.close();
        encodedFin.close();

    }

    public char encrypt(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base + SHIFT + 26) % 26 + base);
        }
        return c;
    }

    public char decrypt(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base - SHIFT + 26) % 26 + base);
        }
        return c;
    }

    public void compareFiles() throws IOException{
        FileReader originalFin = new FileReader(INPUT_FILE_PATH);
        FileReader recoveredFin = new FileReader(RECOVERED_FILE_PATH);

        int c1, c2;
        while ((c1 = originalFin.read()) != -1 && (c2 = recoveredFin.read()) != -1) {
            if (c1 != c2) {
                System.out.println("Files are different!");
                originalFin.close();
                recoveredFin.close();
                return;
            }
        }
        System.out.println("Files are identical!");
        originalFin.close();
        recoveredFin.close();
    }
}

public class App {
    public static void main(String[] args) throws IOException{
        FileManager fm = new FileManager();
        fm.encodeAndDecodeFile();
        fm.compareFiles();
    }
}
