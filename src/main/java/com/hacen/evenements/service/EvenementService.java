package com.hacen.evenements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Type;

public interface EvenementService {
	Evenement saveEvenement(Evenement e);
	Evenement updateEvenement(Evenement e);
	void deleteEvenement(Evenement e);
	 void deleteEvenementById(Long id);
	 Evenement getEvenement(Long id);
	List<Evenement> getAllEvenements();
	Page<Evenement> getAllEvenementsParPage(int page, int size);
	List<Evenement> findByNomEvenement(String nom);
	List<Evenement> findByNomEvenementContains(String nom);
	List<Evenement> findByNomCapacite (String nom, Double capacite);
	List<Evenement> findByType (Type type);
	List<Evenement> findByTypeIdType(Long id);
	List<Evenement> findByOrderByNomEvenementAsc();
	List<Evenement> trierEvenementsNomsCapacite();

}
