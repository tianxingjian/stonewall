package com.stonewall.web.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.util.Assert;

public interface FileRepository {

	/**
	 * Save a file and return the file id. {@link Assert} the file is not null and exists
	 * 
	 * @param file
	 *            not null and exists
	 * @return fileName donating the file's path used as a unique key to retreive the file
	 * @throws IOException
	 */
	String save(File file) throws IOException;

	/**
	 * Delete any file that matches passed fileName. {@link Assert} fileName is not null
	 * 
	 * @param fileName
	 *            must not be null or empty
	 */
	void delete(String fileName);

	/**
	 * Find a single record that matches the fileLocation and return a file to it. {@link Assert} id is not null
	 * 
	 * @param fileLocation
	 *            must not be null or empty
	 * @return
	 * @throws IOException
	 */
	File findOne(String fileLocation) throws IOException;

}
