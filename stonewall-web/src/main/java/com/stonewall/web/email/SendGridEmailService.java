package com.stonewall.web.email;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SendGridEmailService implements EmailService {

	protected static Logger logger = Logger.getLogger(SendGridEmailService.class);

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public StatusResponse send(EmailMessage message) {
		try {
			MultiValueMap<String, Object> vars = new LinkedMultiValueMap<String, Object>();
			vars.add(SendGridParameter.API_USER, "yodareloaded");
			vars.add(SendGridParameter.API_KEY, "reloaded");
			vars.add(SendGridParameter.SENDER_NAME, message.getReceiverName());
			vars.add(SendGridParameter.SENDER_EMAIL, message.getReceiverEmail());
			vars.add(SendGridParameter.SUBJECT, message.getSubject());
			vars.add(SendGridParameter.TEXT, "");
			vars.add(SendGridParameter.HTML, message.getBody());
			vars.add(SendGridParameter.RECEIVER_EMAIL, "john@stonewallgardencentre.com");
			vars.add(SendGridParameter.RECEIVER_NAME, "John Cummins");

			restTemplate.postForLocation(SendGridParameter.URL, vars);
		} catch (Exception ex) {
			logger.error("Error sending email message", ex);
			return new StatusResponse(false, "An error has occurred!");
		}
		logger.debug("Email message sent sucessfully");
		return new StatusResponse(true, "Message sent");
	}

}
