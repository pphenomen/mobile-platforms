package property;

import java.util.Objects;

public abstract class Property {
    protected double worth;

    public Property(double worth) {
        this.worth = worth;
    }

    public double getWorth() {
        return worth;
    }

    public abstract double calculateTax();

    public void sell() {
        System.out.println("Недвижимость продана.");
    }

    public void transfer() {
        System.out.println("Передача права собственности на недвижимость.");
    }

    @Override
    public String toString() {
        return "Недвижимость:" + "стоимость = " + worth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Property property = (Property) obj;
        return Double.compare(property.worth, worth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(worth);
    }
}
