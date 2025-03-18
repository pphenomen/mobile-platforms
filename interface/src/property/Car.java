package property;

public class Car extends AbstractProperty {
    private double volume;
    private int year;

    public Car(double worth, double volume, int year) {
        super(worth);
        this.volume = volume;
        this.year = year;
    }

    public double getVolume() {
        return volume;
    }
    public int getYear() {
        return year;
    }

    @Override
    public double calculateTax() {
        return (1.0 / 10) * volume;
    }

    @Override
    public String toString() {
        return "Автомобиль: стоимость = " + worth + ", объем двигателя = " + volume + ", год выпуска = " + year + ", налог = " + calculateTax();
    }
}
