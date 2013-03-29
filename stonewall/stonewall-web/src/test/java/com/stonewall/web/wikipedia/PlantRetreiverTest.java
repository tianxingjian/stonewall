package com.stonewall.web.wikipedia;

import org.junit.Test;

public class PlantRetreiverTest {

	private PlantRetreiver plantRetreiver = new PlantRetreiver();

	@Test
	public void testPlantRetreiver() {
		String result = plantRetreiver.getPlantInfo();
		System.out.println(result);
	}

	@Test
	public void testGson() {
		Query result = plantRetreiver.getGson();
		System.out.println(result);
	}

}
