package com.autfish._basic.innerclass;

public class Client {
	
	public Client() {
		
	}
	
	public Client(String name, String ip) {
		this.name = name;
		this.ip = ip;
	}

	private String name;
	private String ip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
