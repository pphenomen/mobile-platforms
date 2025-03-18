package property;

import java.util.Objects;

public interface Property {
    double calculateTax();
    double getWorth();

    default void sell() {
        System.out.println("Недвижимость продана.");
    }

    default void transfer() {
        System.out.println("Передача права собственности на недвижимость.");
    }
}
