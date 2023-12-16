package Card;

import java.util.Random;

public class Card {
    public enum Type {
        A, B, C, D;
    }
    public int patten, number;
    public Random random = new Random();
    // Constructor
    public Card(){}
    // Methord
    public void showCard(){
        System.out.printf("Card : %s %d\n", Type.values()[patten], this.number + 1);
    }
    public void SetCard(int patten, int number){
        this.patten = patten;
        this.number = number;
    }
}
