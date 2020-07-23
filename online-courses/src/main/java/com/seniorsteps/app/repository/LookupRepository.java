package com.seniorsteps.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorsteps.app.models.Lookup;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, Integer>  {

	
}