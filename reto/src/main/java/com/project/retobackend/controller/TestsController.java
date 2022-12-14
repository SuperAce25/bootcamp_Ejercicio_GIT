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

import com.project.retobackend.model.Tests;
import com.project.retobackend.service.TestService;

@RestController
public class TestsController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/api/tests")
	public ResponseEntity<List <Tests>> getlist(){
		if (testService.getlist().isEmpty()) {
			return new ResponseEntity<List<Tests>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Tests>>(testService.getlist(),null, HttpStatus.OK);
		}
	}

	@GetMapping("/api/tests/{id}")
	public ResponseEntity<Tests> getbyid(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<Tests>(testService.getbyid(id), null, HttpStatus.OK);	
		}catch (Exception e){
			return new ResponseEntity<Tests>(HttpStatus.NOT_FOUND);	
		}
	}
	
	@PostMapping("/api/tests")
	public ResponseEntity<String> post(@RequestBody Tests test){ 
		if (test.getName() != null) {
			testService.saveOrUpdate(test);  
			return new ResponseEntity<String>("Created", null, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/tests")  
	public ResponseEntity<String> put(@RequestBody Tests test){
		if (testService.existbyId(test.getId())) {
			testService.update(test);  
			return new ResponseEntity<String>("Updated", null, HttpStatus.CREATED);
		}else{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/tests/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		if (testService.existbyId(id)) {
			testService.delete(id);
			return new ResponseEntity<String> (HttpStatus.OK);			
		} else{
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
	}
}
