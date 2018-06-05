package com.autfish._spring.step04.beans;

import com.autfish._spring.Car;

public class CarFactory1 {

    public Car createHongqiCar() {
        Car car = new Car();
        car.setBrand("红旗");
        return car;
    }
}
