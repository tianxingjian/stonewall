package com.stonewall.web.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.stonewall.web.model.Picture;
import com.stonewall.web.util.ResourceUtils;

@Repository
public class PictureRepository implements InitializingBean {

	private static final Logger logger = Logger.getLogger(PictureRepository.class);

	@Autowired
	private ResourceUtils utils;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private FileRepository fileRepository;

	public void delete(Picture picture) {
		if (logger.isDebugEnabled()) {
			logger.debug("Deleting picture " + picture.toString());
		}
		fileRepository.delete(picture.getFileName());
		File pictureFile = new File(utils.getPictureDirectory() + picture.getFileName());
		if (!pictureFile.delete()) {
			logger.error("Failed to delete picture " + picture.toString());
		}
		mongoTemplate.remove(picture);
	}

	/**
	 * Returns all pictures and copies the picture file to the specified file location in the {@link Picture} model
	 * 
	 * @return list of all pictures
	 */
	public List<Picture> findAll() {
		List<Picture> pictures = mongoTemplate.findAll(Picture.class);
		for (Picture picture : pictures) {
			File pictureFile = new File(utils.getPictureDirectory() + picture.getFileName());
			if (!pictureFile.exists()) {
				try {
					pictureFile = fileRepository.findOne(pictureFile.getName());
					picture.setPicture(pictureFile);
				} catch (IOException e) {
					logger.error("Error retreiving picture from database" + picture.toString(), e);
				}
			} else {
				picture.setPicture(pictureFile);
			}
		}
		return pictures;
	}

	/**
	 * Find a single picture based on the Id. If the picture is not on the file system, write it.
	 * 
	 * @param id
	 *            of the picture to retrieve
	 * @return picture
	 */
	public Picture findOne(String id) {
		Picture picture = mongoTemplate.findById(id, Picture.class);
		File pictureFile = new File(utils.getPictureDirectory() + picture.getFileName());
		if (!pictureFile.exists()) {
			try {
				pictureFile = fileRepository.findOne(pictureFile.getName());
				picture.setPicture(pictureFile);
			} catch (IOException e) {
				logger.error("Error retreiving picture from database" + picture.toString(), e);
			}
		} else {
			picture.setPicture(pictureFile);
		}
		return picture;
	}

	/**
	 * Save picture to database and file store
	 * 
	 * @param picture
	 *            to save
	 */
	public void save(Picture picture) {
		try {
			fileRepository.save(picture.getPicture());
			mongoTemplate.save(picture);
		} catch (IOException e) {
			logger.error("Error saving picture " + picture.toString());
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(fileRepository);
		Assert.notNull(mongoTemplate);
	}
}
