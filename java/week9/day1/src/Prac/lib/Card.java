package Prac.lib;

public abstract class Card implements Comparable<Card>{
    private int patten, number;
    public Card(){};

    public abstract void draw(); // 카드 뽑는 기능
    public abstract void showCard();
    public abstract int compareTo(Card o);

    public void setData(int patten, int number) {
        this.patten = patten;
        this.number = number;
    }
    public int GetPatten(){
        return this.patten;
    }
    public int GetNumber(){
        return this.number;
    }
}