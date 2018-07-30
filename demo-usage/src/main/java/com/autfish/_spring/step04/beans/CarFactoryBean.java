package com.autfish._spring.step04.beans;

import com.autfish._spring.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;
	
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setColor(infos[1]);
		car.setMaxSpeed(Integer.parseInt(infos[2]));
		return car;
	}

	public Car createCar() {
		return new Car();
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
