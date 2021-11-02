package org.nbrendah.travel;

import java.util.ArrayList;
import java.util.List;

import org.nbrendah.travel.repository.entity.Travel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelController.class);

	private TravelService travelService;

	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}

	@RequestMapping("/travels")
	public List<Travel> travels(@RequestParam(value = "origin", defaultValue = "uganda") String origin) {
		LOGGER.info("processing Request");

		Iterable<Travel> travels = travelService.getTravels(origin);
		List<Travel> result = new ArrayList<>();
		travels.forEach(result::add);
		return result;
	}
}
