package com.hacen.evenements.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEven", types = { Evenement.class })

public interface EvenementProjection {
	public String getNomEvenement();
}
