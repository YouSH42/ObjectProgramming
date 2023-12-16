package Prac.App;
import java.util.*;

import Prac.lib.Card;

class OneCard extends Card{
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
        private String symbol;
        Number(String symbol) { this.symbol = symbol;   }
        String GetNum(){  return this.symbol; }
    }
    @Override
    public void draw() {
        Random random = new Random();
        int patten = random.nextInt(4);
        int number = random.nextInt(13);
        setData(patten, number);
    }
    @Override
    public void showCard() {
        System.out.printf("OneCard: %s %s", Patten.values()[this.GetPatten()].GetName(), Number.values()[this.GetNumber()].GetNum());
    }
    @Override
    public int compareTo(Card o) {
        if (this.GetPatten() > o.GetPatten()) {
            System.out.printf("더 큰 카드는 %s %s 입니다.\n", Patten.values()[this.GetPatten()],
                    Number.values()[this.GetNumber()].GetNum());
            return 1;
        } else if (this.GetPatten() < o.GetPatten()) {
            System.out.printf("더 큰 카드는 %s %s 입니다.\n", Patten.values()[o.GetPatten()],
                    Number.values()[o.GetNumber()].GetNum());
            return -1;
        } else {
            if (this.GetNumber() > o.GetNumber()) {
                System.out.printf("더 큰 카드는 %s %s 입니다.\n", Patten.values()[this.GetPatten()],
                        Number.values()[this.GetNumber()].GetNum());
                return 1;
            } else if (this.GetNumber() < o.GetNumber()) {
                System.out.printf("더 큰 카드는 %s %s 입니다.\n", Patten.values()[o.GetPatten()],
                        Number.values()[o.GetNumber()].GetNum());
                return -1;
            } else {
                return 0;
            }
        }
    }
    public String toString(){
        return "OneCard:" + Patten.values()[this.GetPatten()].GetName() + Number.values()[this.GetNumber()].GetNum(); 
    }
    public boolean equals(OneCard onecard){
        if(this.GetNumber() == onecard.GetNumber() && this.GetPatten() == onecard.GetPatten()){
            return true;
        }
        else{
            return false;
        }
    }
}

class UnoCard extends Card{
    //enum
    public enum UnoNum {
        One("1"), Two("2"), Three("3"), Four("4"), Five("5"),
        Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
        Skip("Skip"), Reverse("Reverse"), Draw("Draw");
    
        private String RealNumber;
        UnoNum(String RealNumber) {this.RealNumber = RealNumber;}
        String GetRealNumber() {return this.RealNumber;}
    }
    public enum Color {
        Red, Yellow, Green, Blue;
    }
    public String toString(){
        return "UnoCard:"+ Color.values()[this.GetPatten()] + " " + UnoNum.values()[this.GetNumber()].GetRealNumber(); 
    }
    @Override
    public void draw() {
        Random random = new Random();
        int patten = random.nextInt(4);
        int number = random.nextInt(13);
        setData(patten, number);
    }

    @Override
    public void showCard() {
        System.out.printf("UnoCard: %s %s", Color.values()[this.GetPatten()],
                UnoNum.values()[this.GetNumber()].GetRealNumber());
    }

    @Override
    public int compareTo(Card o) {
        if (this.GetPatten() > o.GetPatten()) {
            System.out.printf("더 큰 카드는 %s %s 입니다.\n", Color.values()[this.GetPatten()],
                    UnoNum.values()[this.GetNumber()].GetRealNumber());
            return 1;
        } else if (this.GetPatten() < o.GetPatten()) {
            System.out.printf("더 큰 카드는 %s %s 입니다.\n", Color.values()[o.GetPatten()],
                    UnoNum.values()[o.GetNumber()].GetRealNumber());
            return -1;
        } else {
            if (this.GetNumber() > o.GetNumber()) {
                System.out.printf("더 큰 카드는 %s %s 입니다.\n", Color.values()[this.GetPatten()],
                        UnoNum.values()[this.GetNumber()].GetRealNumber());
                return 1;
            } else if (this.GetNumber() < o.GetNumber()) {
                System.out.printf("더 큰 카드는 %s %s 입니다.\n", Color.values()[o.GetPatten()],
                        UnoNum.values()[o.GetNumber()].GetRealNumber());
                return -1;
            } else {
                return 0;
            }
        }
    }
}


public class App {
    static int sameCard(OneCard card, double input){
        OneCard onecard = new OneCard();
        onecard.draw();
        boolean IsSame = onecard.equals(card);
        int count = 0;
        for(int i = 0; i < input; i++){
            if(IsSame){
                count++;
            }
            onecard.draw();
            IsSame = onecard.equals(card);
        }
        double result = count/input;
        System.out.println("동일한 카드가 뽑힐 확률: "+ result);
        return count;
    }
    public static void main(String[] args) throws Exception {
        OneCard p1 = new OneCard();
        OneCard p2 = new OneCard();
        UnoCard up1 = new UnoCard();

        p1.draw();
        p2.draw();
        up1.draw();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(up1);
        sameCard(p1, 1000);
    }
}
