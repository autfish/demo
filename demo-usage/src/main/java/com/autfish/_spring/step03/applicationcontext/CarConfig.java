package com.autfish._spring.step03.applicationcontext;

import com.autfish._spring.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //声明当前类是一个配置类
public class CarConfig {

	@Bean(name = "car3")
	public Car buildCar() {
		Car car = new Car();
		car.setBrand("benz");
		car.setColor("black");
		car.setMaxSpeed(240);
		return car;
	}
}
