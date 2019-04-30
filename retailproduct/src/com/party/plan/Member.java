package com.party.plan;

public class Member 
{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	private String name;
	private int discount;
	public Member(String name, int discount) {
		super();
		this.name = name;
		this.discount = discount;
	}

}
