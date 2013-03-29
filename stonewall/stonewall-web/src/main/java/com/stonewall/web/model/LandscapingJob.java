package com.stonewall.web.model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class LandscapingJob {

	@Id
	private String id;

	private String name;

	private String description;

	private List<Picture> pictures = new LinkedList<Picture>();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID : " + id + "\n");
		sb.append("Name : " + name + "\n");
		sb.append("Description : " + description + "\n");
		sb.append("Amount of pictures : " + pictures.size());
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
