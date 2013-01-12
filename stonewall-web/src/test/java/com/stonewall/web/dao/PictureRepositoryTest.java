package com.stonewall.web.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import com.stonewall.web.model.Picture;
import com.stonewall.web.util.ResourceUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:mongo-test-context.xml"
})
public class PictureRepositoryTest {

	private static final Logger logger = Logger.getLogger(PictureRepositoryTest.class);

	@Autowired
	private PictureRepository pictureRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ResourceUtils utils;

	@Before
	public void setup() throws IOException {
		mongoTemplate.dropCollection(Picture.class);
		File stonewallTemp = new File(utils.getPictureDirectory());
		if (stonewallTemp.exists()) {
			FileUtils.deleteDirectory(stonewallTemp);
		}
		stonewallTemp.mkdirs();
	}

	@Test
	public void testResultsDaoConstruction() {
		TestCase.assertNotNull(pictureRepository);
	}

	@Test
	public void testAdd() throws IOException {
		Picture picture = newPicture();
		pictureRepository.save(picture);
		if (!picture.getPicture().delete()) {
			TestCase.fail("Picture failed to delete, cant run test");
		}
		List<Picture> pictures = pictureRepository.findAll();
		TestCase.assertEquals(1, pictures.size());
		Picture dbPicture = pictures.get(0);
		TestCase.assertEquals(dbPicture.getDescription(), picture.getDescription());
		TestCase.assertEquals(dbPicture.getFileName(), picture.getFileName());
		TestCase.assertTrue(dbPicture.getPicture().exists());
		TestCase.assertNotNull(dbPicture.getId());
	}

	public Picture newPicture() throws IOException {
		Picture picture = new Picture();
		picture.setDescription("description 1");

		File pictureFile = new File(utils.getPictureDirectory(), UUID.randomUUID().toString() + "_background.jpg");
		pictureFile.getParentFile().mkdirs();

		FileCopyUtils.copy(new File("target/test-classes/background.jpg"), pictureFile);
		if (!pictureFile.exists()) {
			TestCase.fail("Failed to copy test picture resource");
		}
		logger.info("Copying file to " + pictureFile.getAbsolutePath());
		picture.setFileName(pictureFile.getName());
		picture.setPicture(pictureFile);
		return picture;
	}

	@Test
	public void testDelete() throws IOException {
		Picture picture = newPicture();
		pictureRepository.save(picture);
		List<Picture> pictures = pictureRepository.findAll();
		TestCase.assertEquals(1, pictures.size());
		pictureRepository.delete(pictures.get(0));
		pictures = pictureRepository.findAll();
		TestCase.assertEquals(0, pictures.size());
	}
}
