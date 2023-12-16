import java.util.Scanner;

public class App {
    enum Patten {
        clover("클로버"),       //0은 클로버
        heart("하트"),         //1은 하트 
        Diamond("다이아몬드"),  //2는 다이야
        Space("스페이스");      //3은 스페이

        public String korName;

        Patten(String name){  this.korName = name; }
        String GetName(){  return this.korName;  }
    }

    enum Number{
        ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
        SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
        JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

        private final String symbol;

        Number(String symbol) {
            this.symbol = symbol;
        }
        String GetNum(){
            return this.symbol;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("플레이어 숫자: ");
        int input = scanner.nextInt();

        int[] NumArray = new int[input];
        int[] PattenArray = new int[input];

        for(int i = 0; i < input; i++){
            int patten, number;
            boolean Isduplication;
            do{
                number = (int) ((Math.random() * 10000) % 13) + 2;
                patten = (int) ((Math.random() * 10000) % 4);
                Isduplication = false;

                for(int k = 0; k < i; k++){
                    if(NumArray[i] == number && PattenArray[i] == patten){
                        Isduplication = true;
                        break;
                    }
                }
            }while(Isduplication);

            NumArray[i] = number;
            PattenArray[i] = patten;
        }
        //enum으로 변환
        Patten[] pattenArray = new Patten[input];
        Number[] numberArray = new Number[input];
        for(int i = 0; i < input; i++){
            pattenArray[i] = Patten.values()[PattenArray[i]];
            numberArray[i] = Number.values()[NumArray[i]-2];
        }
        for(int i = 0; i < input; i++){
            System.out.println("참가자" + (1+i) + " : " + pattenArray[i].GetName() + numberArray[i].GetNum());
        }

        // 비교 후 출력
        int winner = 0;
        int Issame = 0;
        int[] tmp = new int[input];
        int MaxNumber = -1;
        for(int i = 0; i < input; i++){
            if(NumArray[i] > MaxNumber){
                MaxNumber = NumArray[i];
                winner = i;
                Issame = 0;
            }
            else if (NumArray[i] == MaxNumber){
                tmp[Issame] = i;
                Issame++;
            }
        }
        if(Issame > 0){
            for(int i = 0; i < Issame; i++){
                if(pattenArray[tmp[i]].ordinal() > pattenArray[winner].ordinal()){
                    winner = tmp[i];
                }
            }
        }

        System.out.println((winner + 1) + "가 이겼습니다.");
        scanner.close();
    }
}
