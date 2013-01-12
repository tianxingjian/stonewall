package com.stonewall.web.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.stonewall.web.model.LandscapingJob;
import com.stonewall.web.model.Picture;
import com.stonewall.web.util.ResourceUtils;

@Repository
public class LandscapingRepositoryImpl implements InitializingBean {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LandscapingRepositoryImpl.class);

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ResourceUtils utils;

	/**
	 * Removes a landscaping job and all pictures attached to it.
	 * 
	 * @param landscapingJob
	 */
	public void delete(LandscapingJob landscapingJob) {
		if (logger.isDebugEnabled()) {
			logger.debug("Deleting picture " + landscapingJob.toString());
		}
		for (Picture picture : landscapingJob.getPictures()) {
			fileRepository.delete(picture.getFileName());
			if (!picture.getPicture().delete()) {
				logger.error("Failed to delete picture " + picture.toString());
			}
		}
		mongoTemplate.remove(landscapingJob);
	}

	public LandscapingJob findById(String id) {
		return mongoTemplate.findById(id, LandscapingJob.class);
	}

	/**
	 * Removes the {@link LandscapingJob} for passed id
	 * 
	 * @param id
	 */
	public void delete(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("Deleting job with id " + id.toString());
		}
		mongoTemplate.remove(findById(id));
	}

	/**
	 * Returns all landscaping jobs with the pictures
	 * 
	 * @return list of all {@link LandscapingJob}
	 */
	public List<LandscapingJob> findAll() {
		List<LandscapingJob> landscapingJobs = mongoTemplate.findAll(LandscapingJob.class);
		for (LandscapingJob landscapingJob : landscapingJobs) {
			for (Picture picture : landscapingJob.getPictures()) {
				File pictureFile = new File(utils.getPictureDirectory(), picture.getName());
				if (!pictureFile.exists()) {
					try {
						pictureFile = fileRepository.findOne(picture.getFileName());
						picture.setPicture(pictureFile);
					} catch (IOException e) {
						logger.error("Error retreiving picture from database" + picture.toString(), e);
					}
				} else {
					picture.setPicture(pictureFile);
				}
			}
		}

		return landscapingJobs;
	}

	/**
	 * Save landscapingJob to database and file store
	 * 
	 * @param landscapingJob
	 *            to save
	 */
	public void save(LandscapingJob landscapingJob) {
		try {
			for (Picture picture : landscapingJob.getPictures()) {
				if (picture != null && picture.getPicture() != null) {
					fileRepository.save(picture.getPicture());
					mongoTemplate.save(picture);
				}
			}
			mongoTemplate.save(landscapingJob);
		} catch (IOException e) {
			logger.error("Error saving picture " + landscapingJob.toString());
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(fileRepository, "File repository autowiring failing");
		Assert.notNull(mongoTemplate, "Mongo Template autowiring failing");
	}

}
