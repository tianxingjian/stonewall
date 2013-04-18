package com.stonewall.web.dao;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stonewall.web.model.Plant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:mongo-test-context.xml"
})
public class PlantRepositoryTest {

	@Autowired
	private PlantRepository plantRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		mongoTemplate.dropCollection(Plant.class);
	}

	@Test
	public void testResultsDaoConstruction() {
		TestCase.assertNotNull(plantRepository);
	}

	@Test
	public void testAdd() {
		Plant plant = newPlant();
		plantRepository.save(plant);
		List<Plant> plants = plantRepository.findAll();
		TestCase.assertEquals(1, plants.size());
		Plant dbPlant = plants.get(0);
		TestCase.assertEquals(dbPlant.getName(), plant.getName());
		TestCase.assertEquals(dbPlant.getDescription(), plant.getDescription());
		TestCase.assertEquals(dbPlant.getPrice(), plant.getPrice());
	}

	public Plant newPlant() {
		Plant plant = new Plant();
		plant.setName("plantName");
		plant.setDescription("plantDesc");
		plant.setPrice(3.50);
		return plant;
	}

	@Test
	public void testDelete() {
		Plant plant = newPlant();
		plantRepository.save(plant);
		List<Plant> plants = plantRepository.findAll();
		TestCase.assertEquals(1, plants.size());
		plantRepository.delete(plants.get(0));
		plants = plantRepository.findAll();
		TestCase.assertEquals(0, plants.size());
	}
}
