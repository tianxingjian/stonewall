package com.stonewall.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the welcome page
 */
@RequestMapping("welcome")
@Controller
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);

	public WelcomeController() {
		logger.info("initialising welcome controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void getWelcome(Model model) {
		logger.info("Welcome controller get request");
	}

}
