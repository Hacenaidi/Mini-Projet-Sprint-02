package com.hacen.evenements.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.service.EvenementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EvenementRESTController {
	@Autowired
	EvenementService evenementService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Evenement> getAllEvenements() {
		return evenementService.getAllEvenements();
		}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Evenement getEvenmentById(@PathVariable("id") Long id) {
	return evenementService.getEvenement(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Evenement createEvenement(@RequestBody Evenement evenement) {
	return evenementService.saveEvenement(evenement);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Evenement updateEvenement(@RequestBody Evenement evenement) {
	return evenementService.updateEvenement(evenement);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		evenementService.deleteEvenementById(id);
	}
	@RequestMapping(value="/evenementtype/{idType}",method = RequestMethod.GET)
	public List<Evenement> getEvenementsByTypeID(@PathVariable("idType") Long idType) {
	return evenementService.findByTypeIdType(idType);
	}
}
