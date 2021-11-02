package org.nbrendah.travel;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.opentelemetry.extension.annotations.WithSpan;

@Component
public class TravelClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelClient.class);

	@Value("${app.provider.url}")
	private String providerUrl;

	@Autowired
	private RestTemplate restTemplate;

	@WithSpan
	public List<Travel> getTravels(String origin) {
		LOGGER.info("Getting Travels from {}", providerUrl);

		ResponseEntity<Travel[]> response = restTemplate.getForEntity(providerUrl, Travel[].class);

		return Arrays.asList(response.getBody());
	}
}
