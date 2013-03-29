package com.stonewall.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stonewall.web.model.Plant;

public interface PlantRepository extends CrudRepository<Plant, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<Plant> findAll();

}
