import java.util.*;
import java.io.*;

class FileManager{
    private String INPUT_FILE_PATH = "/Users/sanghyun/Develop/java/quiz2-2/src/ciphertext.txt";
    private String ENCODED_FILE_PATH = "/Users/sanghyun/Develop/java/quiz2-2/src/encode.txt";
    private int SHIFT;
    private String password = "password";

    public void encodeAndDecodeFile() throws IOException{
        int c;
        for(int i = 0; i < 100; i++){
            SHIFT = i;
            FileReader fin = new FileReader(INPUT_FILE_PATH);
            FileWriter fout = new FileWriter(ENCODED_FILE_PATH);
            while ((c = fin.read()) != -1) {
                // System.out.print(((char) c));
                fout.write(decrypt((char) c));
            }
            fin.close();
            fout.close();
            if(findPassword()){
                System.out.println(i + "번째 복호화 성공");
                break;
            }
            else{
                System.out.println(i + "번째 복호화 실패");
            }
        }
    }

    public char decrypt(char c) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            return (char) ((c - base - SHIFT + 26) % 26 + base);
        }
        return c;
    }
    public boolean findPassword() throws IOException{
        String tmp = "";
        FileReader recoveredFin = new FileReader(ENCODED_FILE_PATH);
        int c;
        while ((c = recoveredFin.read()) != -1) {
            tmp = tmp + ((char)c);
        }
        // String[] stChange1 = tmp.split("\\s");
        for (int i = 0; i < 100; i++) {
            if(tmp.contains(password)) {
                recoveredFin.close();
                return true;
            } 
        }
        recoveredFin.close();
        return false;
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        FileManager fm = new FileManager();
        fm.encodeAndDecodeFile();
    }
}
