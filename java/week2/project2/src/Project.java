import java.util.Scanner;

public class Project {
    public static void oddtest(String name, int[] scores){
        int sum = 0;
        for(int i = 0; i < 4; i++){
        if(scores[i] > 40){
            sum += scores[i];
        }
        else{
            System.out.println("fail");
            return ;
        }
    }
        int result = sum / 4;
        if(result >=80 ){
            System.out.println("한국어 : " + scores[0]);
            System.out.println("컴퓨터구조 : " + scores[1]);
            System.out.println("데이터베이스 : " + scores[2]);
            System.out.println("소프트웨어공학 : " + scores[3]);
            System.out.println("평균점수 : " + result);
            System.out.println("pass");
            return ;
        }
        System.out.println("fail!!");

    }
    public static void eventest(String name, int[] scores){
        int sum = 0;
        for(int i = 0; i < 4; i++){
        if(scores[i] > 40){
            sum += scores[i];
        }
        else{
            System.out.println("fail");
            return ;
        }
    }
        int result = sum / 4;
        if(result >=80 ){
            System.out.println("한국어 : " + scores[0]);
            System.out.println("영어 : " + scores[1]);
            System.out.println("세법 : " + scores[2]);
            System.out.println("국제법 : " + scores[3]);
            System.out.println("평균점수 : " + result);
            System.out.println("pass");
            return ;
        }
        System.out.println("fail!!");
    }
    public static void main(String[] args) throws Exception {
        int[] scores = new int[4];
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("NAME : ");
        String name = scanner.next();
        System.out.printf("NUMBER : ");
        int number = scanner.nextInt();
        for(int i = 0; i < 4; i++){
            System.out.printf("SCORE : ");
            scores[i] = scanner.nextInt();
        }

        //가형인 경우
        if((number % 2) == 1){
            oddtest(name, scores);
        }
        //나형인 경우
        else{
            eventest(name, scores);
        }
        scanner.close();
    }
}
