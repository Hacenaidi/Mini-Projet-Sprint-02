package com.hacen.evenements.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Type;
import com.hacen.evenements.repos.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementRepository evenementRepository;
	@Override
	public Evenement saveEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public void deleteEvenement(Evenement e) {
		evenementRepository.delete(e);
		
	}

	@Override
	public void deleteEvenementById(Long id) {
		evenementRepository.deleteById(id);
		
	}

	@Override
	public Evenement getEvenement(Long id) {
		return evenementRepository.findById(id).get();
		
	}

	@Override
	public List<Evenement> getAllEvenements() {
		
		return evenementRepository.findAll();
	}
	
	@Override
	public Page<Evenement> getAllEvenementsParPage(int page, int size) {
	return evenementRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Evenement> findByNomEvenement(String nom) {
		
		return evenementRepository.findByNomEvenement(nom);
	}

	@Override
	public List<Evenement> findByNomEvenementContains(String nom) {
		
		return evenementRepository.findByNomEvenementContains(nom);
	}

	@Override
	public List<Evenement> findByNomCapacite(String nom, Double capacite) {
		return evenementRepository.findByNomCapacite(nom, capacite);
	}

	@Override
	public List<Evenement> findByType(Type type) {
		
		return evenementRepository.findByType(type);
	}

	@Override
	public List<Evenement> findByTypeIdType(Long id) {
	
		return evenementRepository.findByTypeIdType(id);
	}

	@Override
	public List<Evenement> findByOrderByNomEvenementAsc() {
		
		return evenementRepository.findByOrderByNomEvenementAsc();
	}

	@Override
	public List<Evenement> trierEvenementsNomsCapacite() {
	
		return evenementRepository.trierEvenementsNomsCapacite();
	}

}
