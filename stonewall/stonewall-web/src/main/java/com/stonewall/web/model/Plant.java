package com.stonewall.web.model;

import org.springframework.data.annotation.Id;

/**
 * Model to hold Plant information
 */
public class Plant {

	@Id
	private String name;

	private String description;

	private String type;

	private double price;

	public Plant() {

	}

	public Plant(String name, String type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Plant toString" + "\n");
		sb.append("name:" + name + "\n");
		sb.append("type:" + type + "\n");
		sb.append("description:" + description + "\n");
		sb.append("price:" + price);
		return sb.toString();
	}

}
