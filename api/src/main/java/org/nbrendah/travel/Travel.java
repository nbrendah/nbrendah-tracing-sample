package org.nbrendah.travel;

import java.util.Date;

public class Travel {

	private String origin;
	private String destination;
	private String airline;
	
	private Date departureTime;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Travel [origin=" + origin + ", destination=" + destination + ", airline=" + airline + ", departureTime="
				+ departureTime + "]";
	}	
}
