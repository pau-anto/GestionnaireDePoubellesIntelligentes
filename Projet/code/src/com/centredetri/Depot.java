package com.centredetri;

import java.time.LocalDate;

public class Depot {
	private LocalDate heureDepot;
	private TypeDechet typeDechet;
	private Float poids;
	private Float ptGagne;
	private Menage menage;

	// Getters et setters
	public LocalDate getHeureDepot() {
		return heureDepot;
	}

	public void setHeureDepot(LocalDate heureDepot) {
		this.heureDepot = heureDepot;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Float getPtGagne() {
		return ptGagne;
	}

	public void setPtGagne(Float ptGagne) {
		this.ptGagne = ptGagne;
	}
	
	

	public Menage getMenage() {
		return menage;
	}

	public void setMenage(Menage menage) {
		this.menage = menage;
	}

	public Depot(Float poids, TypeDechet typeDechet,Menage menage, Poubelle poubelle, Float ptGagne) {
		this.poids = poids;
		this.typeDechet = typeDechet;
		this.heureDepot = LocalDate.now();
	}
}
