package com.autfish.demo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class Goods {

	public Goods() {}
	
	public Goods(int id, String name, float price, Date create) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.create = create;
	}

	private int id;
	
	@Pattern(regexp="[\\u4e00-\\u9fa5]{4,30}")
	private String name;
	
	@DecimalMax(value="1000")
	@DecimalMin(value="1")
	private float price;

	private Date create;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
