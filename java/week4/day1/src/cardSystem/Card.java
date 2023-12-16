package cardSystem;
import java.util.Random;
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
    // Method
    public void PrintCardValue() {
        System.out.println("Player" + this.player + " : " + Patten.values()[patten].GetKorName() + Number.values()[number].GetRealNumber());
    }
    public void PrintPlayers(int input){
        for(int i = 0; i < input; i++){
            PrintCardValue();
        }
    }
    public int GetPatten(){
        return this.patten;
    }
    public int GetNumber(){
        return this.number;
    }
    public boolean Compare(Card card){
        if(this.number == card.number && this.patten == card.patten){
            return true;
        }
        else {
            return false;
        }
    }
    public void Game(int input){
        Scanner scanner = new Scanner(System.in);
        System.out.println("참가자 수를 입력하시요 : ");
        int player = scanner.nextInt();
        Card[] cArray = new Card[input];
        boolean Issame = false;
        if (this.number > card.number) {
            System.out.println("우승자는 " + this.player + "번 입니다.");
            return;
        } else if (this.number < card.number) {
            System.out.println("우승자는 " + card.player + "번 입니다.");
            return;
        }
        else if (this.number == card.number) {
            Issame = true;
        }
        if (Issame) {
            if (this.patten > card.patten) {
                System.out.println("우승자는 " + this.player + "번 입니다.");
                return ;
            }
            else {
                System.out.println("우승자는 " + card.player + "번 입니다.");
                return ;
            }
        }
    }

}
