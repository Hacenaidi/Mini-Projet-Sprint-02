package com.hacen.evenements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Type;
import com.hacen.evenements.service.EvenementService;
import com.hacen.evenements.repos.EvenementRepository;

@SpringBootTest
class EvenementsApplicationTests {
	@Autowired
	private EvenementRepository EvenementRepository;
	@Autowired
	private EvenementService EvenementService;
	@Test
	public void testCreateEvenement() {
	Evenement Even = new Evenement("Crepto Art",100.00,new Date());
	EvenementRepository.save(Even);
	}

	 @Test
	 public void testFindEvenement()
	 {
		 Evenement e = EvenementRepository.findById(4L).get();
	 System.out.println(e);
	 }
	 @Test
	 public void testUpdateEvenement()
	 {
		 Evenement e = EvenementRepository.findById(2L).get();
	 e.setCapacite(200.0);
	 EvenementRepository.save(e);
	 }
	 @Test
	 public void testDeleteEvenement()
	 {
		 EvenementRepository.deleteById(3L);;
	 }

	 @Test
	 public void testListerTousEvenement()
	 {
	 List<Evenement> Even = EvenementRepository.findAll();
	 for (Evenement e : Even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testFindByNomProduitContains()
	 {
	 Page<Evenement> even = EvenementService.getAllEvenementsParPage(0,2);
	 System.out.println(even.getSize());
	 System.out.println(even.getTotalElements());
	 System.out.println(even.getTotalPages());
	 even.getContent().forEach(e -> {System.out.println(e.toString());
	  });
	 
	 }
	 @Test
	 public void testFindByNomEvenement()
	 {
	 List<Evenement> even = EvenementRepository.findByNomEvenement("Isec");
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testFindByNomEvenementContains ()
	 {
	 List<Evenement> even=EvenementRepository.findByNomEvenementContains("Crepto Art");
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 } }
	 @Test
	 public void testfindByCapacite()
	 {
	 List<Evenement> even = EvenementRepository.findByNomCapacite("Isec", 100.0);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testfindByTypeIdType()
	 {
	 List<Evenement> even = EvenementRepository.findByTypeIdType(1L);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	  }
	 @Test
	 public void testfindBytype()
	 {
	 Type type = new Type();
	 type.setIdType(1L);
	 List<Evenement> even = EvenementRepository.findByType(type);
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }

	 @Test
	 public void testfindByOrderByNomEvenementAsc()
	 {
	 List<Evenement> even =EvenementRepository.findByOrderByNomEvenementAsc();
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }
	 @Test
	 public void testtrierEvenementsNomsCapacite()
	 {
	 List<Evenement> even = EvenementRepository.trierEvenementsNomsCapacite();
	 for (Evenement e : even)
	 {
	 System.out.println(e);
	 }
	 }


}
