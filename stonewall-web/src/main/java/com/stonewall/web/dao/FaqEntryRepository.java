package com.stonewall.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stonewall.web.model.FaqEntry;

public interface FaqEntryRepository extends CrudRepository<FaqEntry, String> {

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	List<FaqEntry> findAll();

}
