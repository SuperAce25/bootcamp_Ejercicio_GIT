package com.project.retobackend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.retobackend.model.Affiliate;
import com.project.retobackend.model.Appointment;
import com.project.retobackend.repository.AffiliateRepository;

@Service
public class AffiliateService {
	
	@Autowired
	AffiliateRepository affiliateRepository;
	
	//Entrega todo el listado de registros de la tabla, con todos sus campos
		public List <Affiliate> getlist(){
			List <Affiliate> affiliates = new ArrayList<Affiliate>();
			affiliateRepository.findAll().forEach(affiliate1 -> affiliates.add(affiliate1));
			return affiliates;
		}
		//Entrega un solo registro que coincida con el id que llega por parámetro, con todos sus campos
		public Affiliate getbyid(long id) {
			return affiliateRepository.findById(id).get();
		}
		//Permite almacenar un nuevo registro en la tabla, recibe en el body la estructura de la tabla, sin el campo id
		public void saveOrUpdate(Affiliate affiliates) {
			affiliateRepository.save(affiliates);
		}
		//Permite eliminar un registro de la tabla, el cual debe coincidir con el id recibido por parámetro
		public void delete(long id) {
			affiliateRepository.deleteById(id);
		}
		//Permite actualizar un campo de la tabla, teniendo presente que el campo id no es un campo modificable, recibe un json con todos los campos de la tabla
		public void update(Affiliate affiliate) {
			affiliateRepository.save(affiliate);
		}
		
		public boolean existbyId(long id) {
			try {
				return affiliateRepository.existsById(id);
			} catch (Exception e) {
				return false;
			}
		}

}
