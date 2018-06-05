package com.autfish._spring.step03.applicationcontext;

import com.autfish._spring.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClassPathXmlApplicationContextDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("_spring/simple.xml");
		Car car = ctx.getBean("car1", Car.class);
		System.out.println(car.getBrand());
		//加载多个配置文件
		//ctx = new ClassPathXmlApplicationContext(new String[] {"_spring/beans1.xml", "_spring/beans2.xml"});
	}
}
