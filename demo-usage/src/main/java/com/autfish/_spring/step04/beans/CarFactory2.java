package com.autfish._spring.step04.beans;

import com.autfish._spring.Car;

public class CarFactory2 {

    public static Car createHongqiCar() {
        Car car = new Car();
        car.setBrand("红旗");
        return car;
    }
}
