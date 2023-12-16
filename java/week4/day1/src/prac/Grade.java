package prac;

import java.util.Scanner;

public class Card {
    public int patten, number, player;
    public String type;
    // Constructor
    public Card() {
        Random random = new Random();
        patten = random.nextInt(4);
        number = random.nextInt(13) + 1;
    }
    public Card(String type){
        Random random = new Random();
        this.type = type;
        number = random.nextInt(13) + 1;
    }
    public Card(int number){
        Random random = new Random();
        patten = random.nextInt(4);
        this.number = number;

    }
    public Card(int type, int number){
        patten = type;
        this.number = number;
    }
  public int average(){
    return (math + science + english)/3;
  }

  // public static void main(String[] args) {
  //   Scanner scanner = new Scanner(System.in);
  //   System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
  //   int math = scanner.nextInt();
  //   int science = scanner.nextInt();
  //   int english = scanner.nextInt();
  //   Grade me = new Grade(math, science, english);
  //   System.out.println("평균은 " + me.average());
  //   scanner.close();
  // }
}
