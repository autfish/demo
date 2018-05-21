package com.autfish._spring.step03.applicationcontext;

import com.autfish._spring.step02.beanfactory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClassPathXmlApplicationContextDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("_spring/step03/applicationcontext/beans1.xml");
		Car car = ctx.getBean("car1", Car.class);
		System.out.println(car.getBrand());
		ctx = new ClassPathXmlApplicationContext(new String[] {"_spring/step03/applicationcontext/beans1.xml", "_spring/step03/applicationcontext/beans2.xml"});
	}
}
