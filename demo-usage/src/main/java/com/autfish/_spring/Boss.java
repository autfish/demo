package com.autfish._spring;


import java.util.List;
import java.util.Map;

public class Boss {

	private Car car;
	private List<String> favorites;
	private Map<String, String> jobs;

	public Boss() {
	}

	public Boss(Car car) {
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<String> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}

	public Map<String, String> getJobs() {
		return jobs;
	}

	public void setJobs(Map<String, String> jobs) {
		this.jobs = jobs;
	}
}
