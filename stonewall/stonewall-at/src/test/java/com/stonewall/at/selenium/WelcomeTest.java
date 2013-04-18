package com.stonewall.at.selenium;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.stonewall.at.util.BaseFirefox;

public class WelcomeTest extends BaseFirefox {

	private static final Logger logger = Logger.getLogger(WelcomeTest.class);

	@Test
	public void testWelcomePage() throws IOException {
		logger.info("Starting ");
		driver.get(baseUrl + "/welcome");
		TestCase.assertEquals("Stonewall Garden Centre", driver.getTitle());
	}
}
