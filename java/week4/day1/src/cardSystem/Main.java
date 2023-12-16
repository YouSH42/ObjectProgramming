package cardSystem;

public class Main {
  public static void main(String[] args) throws Exception {
    Card card1 = new Card(1);
    Card card2 = new Card(2);

    card1.PickUpCard();
    card2.PickUpCard();
    while (card1.Compare(card2)) {
      card2.PickUpCard();
    }
    card1.PrintCardValue();
    card2.PrintCardValue();

    card1.Game(card2);

  }
}
