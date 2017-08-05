package com.woda.leaddash.leadrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.woda.leaddash.model.Lead;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {

}
