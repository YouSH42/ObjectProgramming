package week;

import java.util.*;

public class CardSystem{    // Field
    private int patten, number, playerNumber;
    private static int playerCounter = 1;
    Random random = new Random();
    // Constructor
    public CardSystem(int init){}
    public CardSystem() {
        this.patten = random.nextInt(4);
        this.number = random.nextInt(13) + 1;
        this.playerNumber = playerCounter++;
    }
    public CardSystem(Patten patten){
        this.patten = patten.ordinal();
        this.number = random.nextInt(13) + 1;
        this.playerNumber = playerCounter++;
    }
    public CardSystem(Number number){
        this.number = number.ordinal();
        this.patten = random.nextInt(4);
        this.playerNumber = playerCounter++;
    }
    public CardSystem(Patten patten, Number number){
        this.patten = patten.ordinal();
        this.number = number.ordinal();
        this.playerNumber = playerCounter++;
    }
    // Method
    public int GetPatten(){
        return this.patten;
    }
    public int GetNumber(){
        return this.number;
    }
    public void PrintCardValue() {
        System.out.println("플레이어" + this.playerNumber + " : " + Patten.values()[patten].GetKorName() + Number.values()[number].GetRealNumber());
    }
    public void Program(int input){
        if(input > 52){
            System.out.println("사람이 너무 많습니다.");
            return ;
        }
        CardSystem[] oscArray= new CardSystem[input];
        PickUpCard(oscArray, input);
        PrintPlayer(oscArray, input);
        Winner(oscArray, input);
    }
    static void Winner(CardSystem[] oscArray, int input){
        int winner = 0;
        boolean Issame = false;
        int[] tmp = new int[input];
        int t = 0;
        for(int i = 0; i < input; i++){
            if (oscArray[i].GetNumber() > oscArray[winner].GetNumber()) {
                Issame = false;
                winner = i;
                t = 0;
            }
            else if (oscArray[i].GetNumber() == oscArray[winner].GetNumber()) {
                //동일한 숫자가 있을 경우 해당하는 플레이어의 라벨를 tmp 배열에 저장
                tmp[t] = i;
                t++;
                Issame = true;
            }
        }
        // 동일한 숫자가 있을 경우 
        if(Issame){
            for(int i = 0; i < t; i++){
                if(oscArray[tmp[i]].GetPatten() > oscArray[winner].GetPatten()){
                    winner = tmp[i];
                }
            }
        }
        winner++;
        System.out.println("우승자는 플레이어 "+ winner + " 입니다.");
        System.out.println(
            "우승자의 카드 : " + Patten.values()[oscArray[winner-1].GetPatten()].GetKorName() + Number.values()[oscArray[winner-1].GetNumber()].GetRealNumber()
        );
    }
    static void PrintPlayer(CardSystem[] oscArray, int input){
        //Print Players Card
        for (int i = 0; i < input; i++) {
            oscArray[i].PrintCardValue();
        }
    }
    static void PickUpCard(CardSystem[] oscArray, int input){
        //Pick up card 
        for (int i = 0; i < input; i++) {
            boolean IsNotSame = false;
            do {
                oscArray[i] = new CardSystem();
                IsNotSame = false;
                for (int k = 0; k < i; k++) {
                    if (oscArray[i].GetNumber() == oscArray[k].GetNumber() && oscArray[i].GetPatten() == oscArray[k].GetPatten()) {
                        IsNotSame = true;
                        break;
                    }
                }
            } while (IsNotSame);
        }
    }
}