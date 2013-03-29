package com.stonewall.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stonewall.web.email.EmailMessage;
import com.stonewall.web.email.EmailService;
import com.stonewall.web.email.StatusResponse;

/**
 * Handles requests for the contact page
 */
@RequestMapping("contact")
@Controller
public class ContactController implements InitializingBean {

	private static final Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	private EmailService emailService;

	public ContactController() {
		logger.info("initialising contact controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	public void contactGet(EmailMessage emailMessage, Model model) {
		logger.debug("Received contact get request");
	}

	@RequestMapping(method = RequestMethod.POST)
	public void contact(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("message") String message, Model model) {
		EmailMessage contactMessage = new EmailMessage("Stonewall Garden Centre", message + "\n Phone Number : "
				+ phoneNumber, name, email);
		logger.debug(contactMessage.toString());
		StatusResponse response = emailService.send(contactMessage);
		model.addAttribute("response", response);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(emailService, "Email Service is not autowired");
	}
}
