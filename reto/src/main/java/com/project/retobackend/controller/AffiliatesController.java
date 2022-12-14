package com.project.retobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.retobackend.model.Affiliate;
import com.project.retobackend.service.AffiliateService;

@RestController
public class AffiliatesController {
	
	@Autowired
	private AffiliateService affiliateService;
	
	@GetMapping("/api/affiliates")
	public ResponseEntity<List <Affiliate>> getlist(){
		if (affiliateService.getlist().isEmpty()) {
			return new ResponseEntity<List<Affiliate>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Affiliate>>(affiliateService.getlist(),null, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/affiliates/{id}")
	public ResponseEntity<Affiliate> getbyid(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<Affiliate>(affiliateService.getbyid(id), null, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Affiliate>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/api/affiliates")
	public ResponseEntity<String> post(@RequestBody Affiliate affiliate){ 
		if (affiliate.getName() != null) {
			affiliateService.saveOrUpdate(affiliate);  
			return new ResponseEntity<String>("Created", null, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/affiliates") 
	public ResponseEntity<String> put(@RequestBody Affiliate affiliate){
		if (affiliateService.existbyId(affiliate.getId())) {
			affiliateService.update(affiliate);  
			return new ResponseEntity<String>("Updated", null, HttpStatus.CREATED); 
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/affiliates/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		if (affiliateService.existbyId(id)) {
			affiliateService.delete(id);
			return new ResponseEntity<String> (HttpStatus.OK);			
		} else{
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
	}
}
