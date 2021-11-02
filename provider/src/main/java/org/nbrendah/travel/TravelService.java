package org.nbrendah.travel;

import org.nbrendah.travel.repository.TravelRepository;
import org.nbrendah.travel.repository.entity.Travel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;

@Service
public class TravelService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelService.class);
	
	private TravelRepository travelRepository;
	
	public TravelService(TravelRepository repository) {
		this.travelRepository = repository;
	}

	public Iterable<Travel> getTravels(String origin) {
		doSomeWorkNewSpan();
		return travelRepository.findAll();
	}

	@WithSpan
    public void doSomeWorkNewSpan() {
		LOGGER.info("Doing some work In New span");
        Span span = Span.current();
 
        span.setAttribute("template.a2", "some value");
 
        span.addEvent("template.processing2.start", atttributes("321"));
        span.addEvent("template.processing2.end", atttributes("321"));
    }
 
    private Attributes atttributes(String id) {
        return Attributes.of(AttributeKey.stringKey("app.id"), id);
    }
}
