import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class File {

    static void Outfile() {
        try {
            FileOutputStream outfile = new FileOutputStream("test.txt");
            String str = "Hello World in JAVA";
            byte[] by = str.getBytes();
            outfile.write(by);
            outfile.close();
        } catch (IOException o) {
            o.printStackTrace();
        }

    }

    static void test_reader() {
        try {
            byte[] b = new byte[1024];
            FileInputStream input = new FileInputStream("test.txt");
            input.read(b);
            System.out.println(new String(b)); // byte 배열을 문자열로 변경하여 출력
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Vector<Integer> V = new Vector<Integer>(10);

        V.add(1);
        V.add(2);
        V.add(3);
        V.add(4);
        System.out.println("vector size : " + V.size());
        System.out.println("vector capacity : " + V.capacity());
    }
}