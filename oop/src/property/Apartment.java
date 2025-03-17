package property;

public class Apartment extends Property {
    private String address;
    private double square;

    public Apartment(double worth, String address, double square) {
        super(worth);
        this.address = address;
        this.square = square;
    }

    public String getAddress() {
        return address;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public double calculateTax() {
        return (1.0 / 1000) * square;
    }

    @Override
    public String toString() {
        return "Апартаменты: стоимость = " + worth + ", адрес = '" + address + "', площадь = " + square + ", налог = " + calculateTax();
    }
}
