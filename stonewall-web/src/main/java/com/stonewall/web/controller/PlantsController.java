package com.stonewall.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonewall.web.dao.PlantRepository;
import com.stonewall.web.model.Plant;
import com.stonewall.web.util.PrePopulatePlants;
import com.stonewall.web.util.SortPlants;

/**
 * Handles requests for the plants page
 */
@RequestMapping("plants")
@Controller
public class PlantsController {

	private static final Logger logger = Logger.getLogger(PlantsController.class);

	@Autowired
	private PlantRepository plantRepository;

	public PlantsController() {
		logger.info("initialising home controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void listPlants(Model model) {
		logger.info("PlantsController get request");
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createPlant(Model model) {
		List<Plant> plants = PrePopulatePlants.getPrepopulateList();
		plantRepository.save(plants);
		populateModel(model);
	}

	private void populateModel(Model model) {
		Map<String, List<Plant>> sortedPlants = SortPlants.sortPlants(plantRepository.findAll());
		logger.debug("Populated plants with " + sortedPlants.size() + " categories");
		model.addAttribute("categories", sortedPlants);
	}
}
