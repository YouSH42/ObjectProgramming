import java.util.*;
import java.io.*;

class OneCard{
    private int patten;
    private int number;
    // enum
    public enum Number {
        One("1"), Two("2"), Three("3"), Four("4"), Five("5"),
        Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
        Jack("J"), Queen("Q"), King("K");
    
        private String RealNumber;
        Number(String RealNumber) {this.RealNumber = RealNumber;}
        String GetRealNumber() {return this.RealNumber;}
    }
    public enum Patten {
        CLOVER, HEART, DIAMOND, SPADE;
    }

    public void SetCard(int patten, int number) {
        this.patten = patten;
        this.number = number;
    }
    public int getPatten(){
        return this.patten;
    }
    public int getNumber(){
        return this.number;
    }
}

class player{
    private ArrayList<OneCard> dec;

    public void receiveCard(OneCard card){
        dec.add(card);
    }
    public OneCard giveCard(int index){
        return dec.get(index);
    }
    public OneCard drowCard(OneCard card){
        for(int i = 0; i < dec.size(); i++){
            OneCard Mycard = dec.get(i);
            if(card.getNumber() == Mycard.getNumber()){
                return Mycard;
            }
            else if (card.getPatten() == Mycard.getPatten()){
                return Mycard;
            }
        }
        return null;
    }
}

class Game{
    private player p1;
    private player p2; 
    private OneCard card;
    private ArrayList<OneCard> NotExist;

    public boolean Compare(int patten, int number){
        for(int i = 0 ; i < NotExist.size(); i++){
            OneCard card = NotExist.get(i);
            if (card.getPatten() == patten && card.getNumber() == number) {
                return false;
            }
        }
        return true;
    }
    public OneCard getCard(){
        Random random = new Random();
        OneCard card = new OneCard();
        while (true) {
            int patten = random.nextInt(4);
            int number = random.nextInt(13);
            if (Compare(patten, number)) {
                card.SetCard(patten, number);
                return card;
            }
        }
    }

    public void initGame(){
        for(int i = 0; i < 7; i++){
            OneCard card = getCard();
            p1.receiveCard(card);
            NotExist.add(card);
        }
        for(int i = 0; i < 7; i++){
            OneCard card = getCard();
            p2.receiveCard(card);
            NotExist.add(card);
        }
    }

    public void playGame(){
        initGame();
        while(true){
            OneCard card = p1.giveCard(0);
            card = p2.drowCard(card);
            if(card == null){
                System.out.println("P2 player lose");
                break;
            }

        }
    }
}

public class App {
    public static void main(String[] args) {
        
    }
}
