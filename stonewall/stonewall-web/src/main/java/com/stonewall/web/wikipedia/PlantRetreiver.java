package com.stonewall.web.wikipedia;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class PlantRetreiver {

	private static Logger logger = Logger.getLogger(PlantRetreiver.class);

	private RestTemplate restTemplate = new RestTemplate();

	public String getPlantInfo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		String response = restTemplate.postForObject(
				"http://en.wikipedia.org/w/api.php?action=query&titles=Plants&prop=info&format=json", entity,
				String.class);
		logger.debug(response);
		return response;
	}

	public Query getGson() {
		Gson gson = new Gson();
		return gson.fromJson(getPlantInfo(), Query.class);
	}
}
