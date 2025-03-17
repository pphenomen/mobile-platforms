package main;

import property.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Property> properties = new ArrayList<>();

        Property apt1 = new Apartment(100000, "Ставропольская 223", 50);
        Property apt2 = new Apartment(200000, "Селезнева 106", 70);
        Property car1 = new Car(30000, 2.0, 2018);
        Property car2 = new Car(50000, 3.0, 2020);
        Property house1 = new CountryHouse(500000, 100, 200);
        Property house2 = new CountryHouse(800000, 150, 300);

        addUniqueProperty(properties, apt1);
        addUniqueProperty(properties, apt2);
        addUniqueProperty(properties, car1);
        addUniqueProperty(properties, car2);
        addUniqueProperty(properties, house1);
        addUniqueProperty(properties, house2);
        addUniqueProperty(properties, car1); // дубликат

        for (Property p : properties) {
            System.out.println(p);
        }
    }

    public static void addUniqueProperty(List<Property> list, Property property) {
        if (!list.contains(property)) {
            list.add(property);
        } else {
            System.out.println("Обнаружен дупликат: " + property);
        }
    }
}
