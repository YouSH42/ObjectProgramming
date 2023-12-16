package week;

public enum Patten {
     CLOVER("클로버"),DIAMOND("다이아몬드"), HEART("하트"), SPADE("스페이드");

    private String KorName;
    Patten(String KorName) {this.KorName = KorName;}
    String GetKorName() {return this.KorName;}
}
