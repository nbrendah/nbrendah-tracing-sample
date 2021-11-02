package org.nbrendah;

import org.nbrendah.travel.repository.TravelRepository;
import org.nbrendah.travel.repository.entity.Travel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class SampleProviderApplication {

	@Autowired
	private TravelRepository travelRepository;
	public static void main(String[] args) {
		SpringApplication.run(SampleProviderApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			travelRepository.save(new Travel("SEA", "LAS", "Deltoid", Date.from(Instant.parse("2021-12-01T12:10:00.000Z"))));
			travelRepository.save(new Travel("AFR", "CHI", "Italy", Date.from(Instant.parse("2021-12-04T13:25:00.000Z"))));
			travelRepository.save(new Travel("ENG", "CHI", "Uganda", Date.from(Instant.parse("2021-12-07T17:30:00.000Z"))));
		};
	}
}
