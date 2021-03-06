package com.autfish._spring.step05.custom_editor;

import com.autfish._spring.Car;

import java.beans.PropertyEditorSupport;

public class CarEditor extends PropertyEditorSupport {

	public void setAsText(String text) {
		String[] infos = text.split(",");
		Car car = new Car();
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setColor(infos[2]);
		setValue(car);
	}
}
