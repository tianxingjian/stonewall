package com.stonewall.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.stonewall.web.model.Plant;

public class SortPlants {

	private static final Logger logger = Logger.getLogger(SortPlants.class);

	public static Map<String, List<Plant>> sortPlants(List<Plant> plants) {
		Map<String, List<Plant>> sorted = new TreeMap<String, List<Plant>>();
		if (plants != null) {
			for (Plant plant : plants) {
				if (plant != null) {
					String type = plant.getType();
					logger.debug(plant.toString());
					if (!sorted.containsKey(type)) {
						sorted.put(type, new ArrayList<Plant>());
					}
					sorted.get(type).add(plant);
				}
			}
		}
		return sorted;
	}
}
