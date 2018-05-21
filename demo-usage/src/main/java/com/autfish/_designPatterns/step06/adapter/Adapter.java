package com.autfish._designPatterns.step06.adapter;

public class Adapter extends Target {

	private Adaptee adaptee = new Adaptee();
	
	@Override
	public void request() {
		adaptee.specificRequest();
	}
}
