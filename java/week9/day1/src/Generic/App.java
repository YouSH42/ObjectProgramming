package Generic;

class Apple{
    public String toString(){
        return "사과";
    }
}

class Orange{
    public String toString(){
        return "오렌지";
    }
}

class Plastic{
    public String toString(){
        return "플라스틱";
    }
}

class PrinterGeneric<T>{
    private T ob;

    public void set(T string){
        ob = string;
    }

    public T get(){
        return ob;
    }
}

public class App {
    public static <T> void PrintArray(T[] data){
        int len = data.length;
        for(int i = 0; i < len; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        PrinterGeneric<Apple> apple = new PrinterGeneric<>();
        PrinterGeneric<Orange> orange = new PrinterGeneric<>();
        PrinterGeneric<Plastic> plastic = new PrinterGeneric<>();
        PrinterGeneric<String> object = new PrinterGeneric<>();

        apple.set(new Apple());
        orange.set(new Orange());
        plastic.set(new Plastic());
        object.set("파인애플");

        System.out.println(apple.get());
        System.out.println(orange.get());
        System.out.println(plastic.get());
        System.out.println(object.get());

        // 2번 문제
        Integer[] arrInt = {1,2,3,4,5};
        Character[] arrChar = {'a','b','c','d','e'};
        PrintArray(arrInt);
        PrintArray(arrChar);

    }
}