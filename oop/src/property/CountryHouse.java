package property;

public class CountryHouse extends Property {
    private double square_h;
    private double square_t;

    public CountryHouse(double worth, double square_h, double square_t) {
        super(worth);
        this.square_h = square_h;
        this.square_t = square_t;
    }

    public double getSquareH() {
        return square_h;
    }

    public double getSquareT() {
        return square_t;
    }

    @Override
    public double calculateTax() {
        return (1.0 / 5000) * square_t + (1.0 / 100) * square_h;
    }

    @Override
    public String toString() {
        return "Территория дома: стоимость = " + worth + ", площадь дома = " + square_h + ", площадь территории = " + square_t + ", налог = " + calculateTax();
    }
}
