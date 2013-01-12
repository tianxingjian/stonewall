package com.stonewall.web.model;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Class to hold information on a picture
 */
public class Picture {

	@Id
	private String id;

	/**
	 * Text description to add next to the photo
	 */
	private String description;

	/**
	 * Origional file name
	 */
	private String name;

	@Transient
	/**
	 * File link to the picture.
	 */
	private File picture;

	/**
	 * File name used as a ID
	 */
	private String fileName;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the picture
	 */
	public File getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(File picture) {
		this.picture = picture;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
