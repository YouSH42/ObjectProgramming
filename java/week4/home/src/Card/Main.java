package Card;

import java.util.*;

public class Main {
    static void RandomSetCard(Card card){
        Random random = new Random();
        int patten = random.nextInt(4);
        int number = random.nextInt(13);
        card.SetCard(patten, number);
    }
    public static void main(String[] args) {
        Card[] cards = new Card[3];

        cards[0] = new Card();
        cards[1] = new OneCard();
        cards[2] = new UnoCard();

        for(int i = 0; i < 3;i ++){
            RandomSetCard(cards[i]);
            cards[i].showCard();
        }
    }
}
