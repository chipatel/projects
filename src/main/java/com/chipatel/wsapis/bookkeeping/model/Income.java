package com.chipatel.wsapis.bookkeeping.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cpatel
 *
 */

@XmlRootElement
public class Income {

	private double amount;
	private int id;
	private String name;

	public Income() {

	}

	public Income(int id, String name, double amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + amount;
	}

}
