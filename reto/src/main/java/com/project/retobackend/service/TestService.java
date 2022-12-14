package com.project.retobackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.retobackend.model.Tests;
import com.project.retobackend.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	
	//Entrega todo el listado de registros de la tabla, con todos sus campos
		public List <Tests> getlist(){
			List <Tests> tests = new ArrayList<Tests>();
			testRepository.findAll().forEach(test1 -> tests.add(test1));
			return tests;
		}
		//Entrega un solo registro que coincida con el id que llega por parámetro, con todos sus campos
		public Tests getbyid(long id) {
			return testRepository.findById(id).get();
		}
		//Permite almacenar un nuevo registro en la tabla, recibe en el body la estructura de la tabla, sin el campo id
		public void saveOrUpdate(Tests tests) {
			testRepository.save(tests);
		}
		//Permite eliminar un registro de la tabla, el cual debe coincidir con el id recibido por parámetro
		public void delete(long id) {
			testRepository.deleteById(id);
		}
		//Permite actualizar un campo de la tabla, teniendo presente que el campo id no es un campo modificable, recibe un json con todos los campos de la tabla
		public void update(Tests test) {
			testRepository.save(test);
		}
		
		public boolean existbyId(long id) {
			return testRepository.existsById(id);
		}

}
