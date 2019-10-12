package com.autfish._designPatterns.step07.decorator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ConcreteDecoratorB extends Decorator {

	//装饰: 增加额外的方法
	public void addBehavior() {
		System.out.println("ConcreteDecoratorB do something");
	}
	
	@Override
	public void request() {
		addBehavior();
		super.request();
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
	}
}
