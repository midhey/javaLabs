public class third {
    public void lab (){
        Car vazik = new Car("Lada", "Kalina", 4, "black", 81, true);
        vazik.drive();
        expensiveCars Prado = new expensiveCars("Toyota", "Prado", 4, "black", 345, true);
        Prado.drive();
    }
}

class Car {
    private String Mark;
    private String Model;
    private int wheelsCount;
    private String color;
    private int horsePowers;
    private boolean isNew;

    public Car(String mark, String model, int wheelsCount, String color, int horsePowers, boolean isNew) {
        Mark = mark;
        Model = model;
        this.wheelsCount = wheelsCount;
        this.color = color;
        this.horsePowers = horsePowers;
        this.isNew = isNew;
    }

    public void drive() {
        System.out.println("Wrooom wrooom");
    }

    public void carBreak() {
        System.out.println("Tidish *wheel was flying out*");
    }
}

class expensiveCars extends Car {
    public expensiveCars(String mark, String model, int wheelsCount, String color, int horsePowers, boolean isNew) {
        super(mark, model, wheelsCount, color, horsePowers, isNew);
    }

    public void drive() {
        System.out.println("Expensive wrooom wrooom");
    }
}

