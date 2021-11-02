package org.nbrendah.travel;

import java.util.List;

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
	
	private TravelClient travelClient;
	
	public TravelService(TravelClient travelClient) {
		this.travelClient = travelClient;
	}

	public List<Travel> getTravels(String origin) {
		LOGGER.info("Getting travels for {}", origin);
		List<Travel> travels = this.travelClient.getTravels(origin);
		doSomeWorkNewSpan();
		return travels;
	}
	
	@WithSpan
    private void doSomeWorkNewSpan() {
		LOGGER.info("Doing some work In New span");
        Span span = Span.current();
 
        span.setAttribute("attribute.a2", "some value");
 
        span.addEvent("app.processing2.start", attributes("321"));
        span.addEvent("app.processing2.end", attributes("321"));
    }
 
    private Attributes attributes(String id) {
        return Attributes.of(AttributeKey.stringKey("app.id"), id);
    }
}
