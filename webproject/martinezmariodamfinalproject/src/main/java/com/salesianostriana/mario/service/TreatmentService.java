package com.salesianostriana.mario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.mario.model.Treatment;
import com.salesianostriana.mario.repository.TreatmentRepository;

@Service
public class TreatmentService {

	@Autowired
	TreatmentRepository repository;
	
	@Autowired
	CompanyService companyService;

	public Treatment findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Iterable<Treatment> findAll() {
		return repository.findAll();
	}

	public Treatment save(Treatment entidad) {
		entidad.setCompany(companyService.findDefaultCompany());
		return repository.save(entidad);
	}

	public Treatment remove(Treatment entidad) {
		Treatment deletedTreatment = repository.findById(entidad.getId()).orElse(null);
		if (deletedTreatment != null)
			repository.delete(entidad);
		return deletedTreatment;
	}
	
	public Iterable<Treatment> findByName(String name){
		return repository.findByNameContainingIgnoreCase(name);
	}
	
	public void setHistoricalTrue(Treatment entidad) {
		entidad.setHistorical(true);
		edit(entidad);
	}

	public void edit(Treatment entidad) {
		save(entidad);
	}
	
	public double calculatePriceWithDiscount(Treatment treatment) {
		// Divisor del porcentaje
		double divider = 100,
				result = 0;
		result = treatment.getTotalPrice() - ((treatment.getDiscount()/divider)*treatment.getTotalPrice());
		return result;
	}
	
	public long calculateNumberOfItems() {
		return findAll().spliterator().getExactSizeIfKnown();
	}
	
	public Iterable<Treatment> findAllHistorical() {
		return repository.findByHistoricalTrue();
	}
	
	public Iterable<Treatment> findAllActive() {
		return repository.findByHistoricalFalse();
	}

}
