package api_prac.App;
import java.util.*;

public class apiapi {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] fruits = {"Strawberry", "Watermelon", "Apple", "Orange", "Banana", "Blueberry"};
        int index = random.nextInt(fruits.length); 
        String select = fruits[index];
        StringBuffer answer = new StringBuffer("_".repeat(select.length()));

        while(true){
            boolean IsChange = false;
            char ans;
            System.out.print("Input a character : ");
            ans = scanner.next().charAt(0);
            // 검사 부분
            for(int i = 0; i < select.length(); i++){
                if(select.charAt(i) == ans){
                    String tmp = String.valueOf(ans);
                    answer.replace(i, i+1, tmp);
                    IsChange = true;
                }
            }
            if (!IsChange) {
                System.out.println("No such character!");
            }
            System.out.println("Game : " + answer);

            StringBuffer compare = new StringBuffer(select);
            if(answer.compareTo(compare) == 0){
                System.out.println("Correct Answer!!");
                break;
            }
        }
        scanner.close();
    }
}
