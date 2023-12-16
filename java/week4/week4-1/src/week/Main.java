package week;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CardSystem ocs = new CardSystem(0);
        System.out.printf("몇 명의 플레이어가 있습니까? : ");
        int input = scanner.nextInt();
        ocs.Program(input);
        scanner.close();
    }
}
