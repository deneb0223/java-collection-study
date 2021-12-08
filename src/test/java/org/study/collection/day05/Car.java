package org.study.collection.day05;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class Car implements Comparable {
    public String brand;
    public String numberPlate;
    public int noOfDoors;

    @Override
    public int compareTo(Object o) {
        Car thatCar = (Car) o;
        Car thisCar = this;
        return thisCar.brand.compareTo(thatCar.brand);
    }
}
