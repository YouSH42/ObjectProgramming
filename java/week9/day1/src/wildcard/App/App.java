package wildcard.App;

class Box<T> {
    private T ob;

    public void set(T o){
        ob = o;
    }
    public T get(){
        return ob;
    }
}

public class App {
    public static <T> void swapBox1(Box<T> box1, Box<T> box2){
        T tmp = box1.get();
        box1.set(box2.get());
        box2.set(tmp);
    }
    public static void swapBox2(Box<Integer> box1, Box<Integer> box2){
        Integer tmp = box1.get();
        box1.set(box2.get());
        box2.set(tmp);
    }
    public static void function(Box<? extends Eatable> box){
        System.out.println(box.get());
        box.get.eat();
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);

        Box<Integer> box2 = new Box<>();
        box2.set(55);

        Box<String> box3 = new Box<>();
        box3.set("Hello");

        Box<String> box4 = new Box<>();
        box4.set("World");

        System.out.println(box1.get() + " & " + box2.get());
        swapBox2(box1, box2);
        System.out.println(box1.get() + " & " + box2.get());

        System.out.println(box3.get() + " & " + box4.get());
        swapBox1(box3, box4);
        System.out.println(box3.get() + " & " + box4.get());

    }
}