package com.stonewall.web.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stonewall.web.dao.FaqEntryRepository;
import com.stonewall.web.model.FaqEntry;
import com.stonewall.web.util.SortFaq;

/**
 * Handles requests for the faq page
 */
@RequestMapping("faq")
@Controller
public class FaqController {

	private static final Logger logger = Logger.getLogger(FaqController.class);

	@Autowired
	private FaqEntryRepository faqEntryRepository;

	public FaqController() {
		logger.info("initialising faq controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void listPlants(Model model) {
		logger.info("PlantsController get request");
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createPlant(Model model, @RequestParam("question") String question,
			@RequestParam("answer") String answer) {
		FaqEntry faq = new FaqEntry();
		faq.setQuestion(question);
		faq.setAnswer(answer);
		faqEntryRepository.save(faq);
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateLandscaping(Model model, @RequestParam("id") String id,
			@RequestParam("question") String question, @RequestParam("answer") String answer) {
		logger.debug("Updating faq with id:" + id);
		FaqEntry faq = faqEntryRepository.findOne(id);
		if (faq != null) {
			faq.setQuestion(question);
			faq.setAnswer(answer);
			faqEntryRepository.save(faq);
		}
		populateModel(model);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteLandscaping(Model model, @RequestParam("id") String id) {
		logger.debug("Removing landscape with id:" + id);
		faqEntryRepository.delete(id);
		populateModel(model);
	}

	private void populateModel(Model model) {
		List<FaqEntry> faqEntrys = faqEntryRepository.findAll();
		Collections.sort(faqEntrys, new SortFaq());
		logger.debug("Found " + faqEntrys.size() + " faq enteries");
		model.addAttribute("faqEntrys", faqEntrys);
	}
}
