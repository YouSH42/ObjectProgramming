package Card;

public class UnoCard extends Card{
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
    // Constructor
    public UnoCard(){}
    // Methord
    public void showCard(){
        System.out.printf("Card : %s %s\n", Color.values()[patten], UnoNum.values()[number].GetRealNumber());
    }
}
