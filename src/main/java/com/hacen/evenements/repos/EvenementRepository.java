package com.hacen.evenements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Type;
@RepositoryRestResource(path = "rest")
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	List<Evenement> findByNomEvenement(String nom);
	 List<Evenement> findByNomEvenementContains(String nom); 
	 @Query("select e from Evenement e where e.nomEvenement like %:nom and e.capacite > :capacite")
	 List<Evenement> findByNomCapacite ( @Param("nom") String nom, @Param("capacite") Double capacite);
	 List<Evenement> findByTypeIdType(Long id);
	 @Query("select e from Evenement e where e.type = ?1")
	 List<Evenement> findByType(Type type);
	 @Query("select e from Evenement e order by e.nomEvenement ASC, e.capacite DESC")
	 List<Evenement> trierEvenementsNomsCapacite ();
	 List<Evenement> findByOrderByNomEvenementAsc();


}
