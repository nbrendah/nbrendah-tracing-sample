package org.nbrendah.travel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(TravelController.class);
	
	private TravelService travelService;
	
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@GetMapping("/travels")
    public List<Travel> greeting(@RequestParam(value = "origin", defaultValue = "India") String origin) {
    	LOGGER.info("Before Service Method Call");
        return travelService.getTravels(origin);
    }

}
