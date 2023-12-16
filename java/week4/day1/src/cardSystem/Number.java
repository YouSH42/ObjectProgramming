package cardSystem;

public enum Number {
    Ace("A"), Two("2"), Three("3"), Four("4"), Five("5"),
    Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
    Jack("J"), Queen("Q"), King("K");

    private String RealNumber;
    Number(String RealNumber) {this.RealNumber = RealNumber;}
    String GetRealNumber() {return this.RealNumber;}
}
