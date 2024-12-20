package com.centredetri;

import java.util.ArrayList;
import java.util.List;

public class Poubelle {
    private int idPoubelle;
    private List<TypeDechet> listeTypesDechets; 
    private String emplacement; 
    private Float capaciteMax;
    private Float capacite; 
    private List<Depot> listeDepots = new ArrayList<Depot>();
    private CentreDeTri centredetri;
 
    public CentreDeTri getCentredetri() {
		return centredetri;
	}

	public void setCentredetri(CentreDeTri centredetri) {
		this.centredetri = centredetri;
	}

	public int getIdPoubelle() {
		return idPoubelle;
	}

	public void setIdPoubelle(Integer idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	
	public String getEmplacement() {
		return emplacement;
	}
	
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public Float getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(Float capaciteMax) {
		this.capaciteMax = capaciteMax;
	}
	
	public Float getCapacite() {
		return capacite;
	}
	
	public void setCapacite(Float capacite) {
		this.capacite = capacite;
	}

	public List<Depot> getListeDepots() {
		return listeDepots;
	}

	public void setListeDepots(List<Depot> listeDepots) {
		this.listeDepots = listeDepots;
	}

	public void vider() {
		this.capacite = 0f;
	}
	
	
    public Poubelle(int idPoubelle, List<TypeDechet> listeTypesDechets, String emplacement, CentreDeTri centreDeTri) {
        this.idPoubelle = idPoubelle; //La valeur d'idPoubelle est gérée lorsque l'on ajoute une poubelle
        this.listeTypesDechets = listeTypesDechets;
        this.emplacement = emplacement;
        this.capaciteMax = 200f;
        this.capacite = 0f;
        this.centredetri = centreDeTri; 
    }


    // Méthode pour prévenir que la poubelle est pleine
    public boolean estPleine() {
        return this.capacite >= (90 * this.capaciteMax) / 100; // if the trash is at 90% or more of its capacity;
    }

    // Méthode pour gérer l'ajout de dépôt
    public void ajouterDepot(Menage menage, Float poids, TypeDechet typeDechet) {
		List<Menage> listeMenages = this.centredetri.getListeMenages();
    	if (listeMenages.contains(menage)) // to verify : does it take the override equals into account ?
		{
        	if (this.capaciteMax >= this.capacite + poids)
        	{
        		Float points = Application.pointsParKg * poids;
        		if (! this.listeTypesDechets.contains(typeDechet))
        		{
        			points = - points / 2;
        		}
        		menage.addPoints(points);
        		Depot depot = new Depot(poids, typeDechet, menage, this,points);
        		this.listeDepots.add(depot);
        		this.capacite =+ poids; 
        		if (this.estPleine())
        		{
        			this.centredetri.ajouterPoubellepleine(this);
        		}
        	}
        	else
        	{
        		System.out.println("ERREUR : la poubelle est pleine. Repassez à un autre moment.");
        	}
		}
    	else
    	{
    		System.out.println("ERREUR : Vous n'avez pas accès à cette poubelle");
    	}

    }
}
