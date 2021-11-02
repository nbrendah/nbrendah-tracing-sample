package org.nbrendah.travel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.nbrendah.travel.repository.entity.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {

}
