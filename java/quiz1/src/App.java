class Tire{
    // members
    private int lifecycle;
    // construct
    public Tire(){
        this.lifecycle = 0;
    }
    public Tire(int lifecycle){
        this.lifecycle = lifecycle;
    }

    // method
    public int roll(){
        this.lifecycle -= 1;
        return this.lifecycle;
    }
    public int GetLifeCycle(){
        return this.lifecycle;
    }
    public void Print(){
        System.out.println("Tire 수명: " + this.lifecycle + "회");
    }
    public String PrintTire(){
        return "Tire";
    }
}

class HankookTireTire extends Tire{
    public HankookTireTire(){
        super(5);
    }
    public String PrintTire(){
        return "HankookTire";
    }
    public void Print() {
        System.out.println("HankookTire 수명: " + GetLifeCycle() + "회");
    }
}

class Car{
    // members;
    Tire[] tires;

    // constructor
    public Car(int left_front, int right_front, int left_back, int right_back){
        tires = new Tire[4];
        tires[0] = new Tire(left_front);
        tires[1] = new Tire(right_front);
        tires[2] = new Tire(left_back);
        tires[3] = new Tire(right_back);
    }
    // method
    public void run(){
        System.out.println("[자동차가 달립니다.]");
        for(int i = 0; i < 4; i++){
            int tmp = tires[i].roll();
            if(tmp == 0){
                switch(i){
                    case 0 :
                        System.out.println("*** 앞왼쪽" + tires[i].PrintTire() + "펑크 ***");
                        System.out.println("[자동차가 멈춥니다]");
                        tires[i] = new HankookTireTire();
                        System.out.println("앞왼쪽"+ tires[i].PrintTire()+"로 교체");
                        break;
                    case 1:
                        System.out.println("*** 앞오른" + tires[i].PrintTire() + "펑크 ***");
                        System.out.println("[자동차가 멈춥니다]");
                        tires[i] = new HankookTireTire();
                        System.out.println("앞오른"+ tires[i].PrintTire()+"로 교체");
                        break;
                    case 2:
                        System.out.println("*** 왼쪽" + tires[i].PrintTire() + "펑크 ***");
                        System.out.println("[자동차가 멈춥니다]");
                        tires[i] = new HankookTireTire();
                        System.out.println("뒤왼쪽"+ tires[i].PrintTire()+"로 교체");
                        break;
                    case 3:
                        System.out.println("*** 뒤오른쪽" + tires[i].PrintTire() + "펑크 ***");
                        System.out.println("[자동차가 멈춥니다]");
                        tires[i] = new HankookTireTire();
                        System.out.println("뒤오른쪽"+ tires[i].PrintTire()+"로 교체");
                        break;
                }

                break;
            }
            else {
                System.out.printf("앞왼쪽 ");
                tires[0].Print();
                System.out.printf("앞오른쪽 ");
                tires[1].Print();
                System.out.printf("뒤왼쪽 ");
                tires[2].Print();
                System.out.printf("뒤오른쪽 ");
                tires[3].Print();
            }
        }
        System.out.println("----------------------------");
    }
    public void display(){
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Car newCar = new Car(6,2,3,4);
        newCar.run();
        newCar.run();
    }
}
