package org.nbrendah.travel.repository.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@EntityScan
@Table(name = "travel")
public class Travel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String origin;
	private String destination;
	private String airline;

	@Column(name = "departing")
	private Date departureTime;

	public String getOrigin() {
		return origin;
	}

	public Travel() {
	}

	public Travel(String origin, String destination, String airline, Date departureTime) {
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.departureTime = departureTime;
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
