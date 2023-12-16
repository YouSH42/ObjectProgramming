

class Car {
    private int gasolineGauge;

    public Car(int gasolineGauge) {
        this.gasolineGauge = gasolineGauge;
    }

    public void showCurrentGauge() {
        System.out.println("잔여 가솔린 : " + this.gasolineGauge);
    }

    public int getGasol() {
        return this.gasolineGauge;
    }
}

class HybridCar extends Car {
    private double electricGauge;

    public HybridCar(int gasolineGauge, double electricGauge) {
        super(gasolineGauge);
        this.electricGauge = electricGauge;
    }

    public void showCurrentGauge() {
        System.out.println("잔여 가솔린 : " + getGasol());
        System.out.println("잔여 전기량 : " + this.electricGauge);
    }

    public double getElec() {
        return this.electricGauge;
    }
}

class HybridWaterCar extends HybridCar {
    private int waterGauge;

    public HybridWaterCar(int gasolineGauge, double electricGauge, int waterGauge) {
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
    }

    public HybridWaterCar(double electricGauge, int waterGauge) {
        super(0, electricGauge);
        this.waterGauge = waterGauge;
    }

    public void showCurrentGauge() {
        System.out.println("잔여 가솔린 : " + getGasol());
        System.out.println("잔여 전기량 : " + getElec());
        System.out.println("잔여 워터량 : " + waterGauge);
    }
}

public class Construct {
    public static void main(String[] args) {
        // HybridWaterCar hwCar1 = new HybridWaterCar(4.2, 2);
        // hwCar1.showCurrentGauge();
        // HybridWaterCar hwCar2 = new HybridWaterCar(9, 5.1, 7);
        // hwCar2.showCurrentGauge();
        // HybridCar hwCar3 = new HybridCar(5, 5.1);
        // hwCar3.showCurrentGauge();
        // Car hwCar4 = new Car(10);
        // hwCar4.showCurrentGauge();

        HybridWaterCar test3 = new HybridWaterCar(10, 20);
        Car test4 = test3;
        System.out.println("UpCasting\n");
        test4.showCurrentGauge();

        // Car test = new HybridCar(10, 20);   //Upcasting
        // HybridCar test2 = (HybridCar)test;      // Downcasting
        // System.out.println("DownCasting\n");
        // test2.showCurrentGauge();
    }
}
