package com.zcsolf.entity_and_adapter;
/**
 * 
 * @author Administrator
 * 点卡的类型抽象(50点,100点,150点and so on)
 */
public class Dianka {
	private String name;

	public Dianka(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
