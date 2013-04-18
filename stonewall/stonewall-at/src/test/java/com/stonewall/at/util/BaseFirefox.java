package com.stonewall.at.util;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This would be better done as a spring bean using the init / destroy lifecycles
 */
public class BaseFirefox {

	protected static FirefoxDriver driver;

	protected static final String baseUrl = "http://localhost:8080/stonewall";

	public BaseFirefox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
