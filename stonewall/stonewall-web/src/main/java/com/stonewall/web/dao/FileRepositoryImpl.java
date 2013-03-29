package com.stonewall.web.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import com.mongodb.gridfs.GridFSDBFile;
import com.stonewall.web.util.ResourceUtils;

@Repository
public class FileRepositoryImpl implements FileRepository {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileRepositoryImpl.class);

	@Autowired
	private GridFsTemplate gridTemplate;

	@Autowired
	private ResourceUtils utils;

	@Override
	public String save(File file) throws IOException {
		Assert.notNull(file);
		Assert.isTrue(file.exists());
		FileInputStream fileStream = FileUtils.openInputStream(file);
		gridTemplate.store(fileStream, file.getName());
		if (fileStream != null) {
			fileStream.close();
		}
		return file.getName();
	}

	@Override
	public File findOne(String filename) throws IOException {
		if (filename != null) {
			GridFSDBFile gridFSDBFile = gridTemplate.findOne(new Query(Criteria.where("filename").is(filename)));
			if (gridFSDBFile != null) {
				File outputFile = new File(utils.getPictureDirectory(), filename);
				if (outputFile.exists()) {
					logger.warn("Overwriting file :" + filename);
				}
				if (!outputFile.getParentFile().exists()) {
					logger.info("Creating parent folders for location : " + filename);
					outputFile.getParentFile().mkdirs();
				}
				OutputStream outStream = new FileOutputStream(outputFile);
				FileCopyUtils.copy(gridFSDBFile.getInputStream(), outStream);
				return outputFile;
			} else {
				logger.warn("Cannot find database file for location : " + filename);
			}
		}
		return null;
	}

	@Override
	public void delete(String fileName) {
		Assert.notNull(fileName);
		gridTemplate.delete(new Query(Criteria.where("filename").is(fileName)));
	}

}
