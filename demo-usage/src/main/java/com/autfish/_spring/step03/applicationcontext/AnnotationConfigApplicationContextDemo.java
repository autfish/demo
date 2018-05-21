package com.autfish._spring.step03.applicationcontext;

import com.autfish._spring.step02.beanfactory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		Car car = ctx.getBean("car3", Car.class);
		System.out.println(car.getBrand());
	}
}
