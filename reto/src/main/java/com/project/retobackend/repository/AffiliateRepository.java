package com.project.retobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.retobackend.model.Affiliate;

@Repository
public interface AffiliateRepository extends CrudRepository <Affiliate, Long>{

}
