package com.centredetri;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

	private CentreDeTri centreDeTri; 
	private Menage menageActuel;
	public static Integer pointsParKg = 10;
	private List<BonAchat> listeBonAchats = new ArrayList<BonAchat>(); 

		// Constructor
	    public Application(CentreDeTri centreDeTri) {
	        this.centreDeTri = centreDeTri;
	    }

	    // Methods
	    public void creerCompte(String username, String password)
	    {
	    	System.out.print("You choose to create your Account ");
	    	
	        List<Menage> listeMenages = this.centreDeTri.getListeMenages();
	         
	        for (Menage menage: listeMenages) {
	             if (menage.getUsername().equals(username)) {
	            	System.out.println("ERROR: Your chosen username already exists");
	            	return ; 
	             }
	        }
	         
	        centreDeTri.ajouterMenage(username, password);
	         
	         System.out.println("Account successfully created for " + username); 
	         
	    }
	    
	    public void login(String username, String password) { 
	    	 List<Menage> listeMenages = this.centreDeTri.getListeMenages();

	    	    for (Menage menage : listeMenages) {
	    	        if (menage.equals(username, password)) {
	    	            this.menageActuel = menage;
	    	            System.out.println(menageActuel);
	    	            System.out.println("You are successfully logged in!");
	    	            return;
	    	        }
	    	    }
	         
	         System.out.println("ERROR: invalid password or username");
	    }
	    
	    public void logout(){
	    	this.menageActuel = null; 
	    	System.out.println("You are successfully logged out");
	    }
	    
	    public float consulterPointsTotal() {
	        return this.menageActuel.getTotalPoints();
	    }
	    
	    
	    public List<Depot> afficherListeDepots() { // method to display the list of deposit of logged in menage 
	    	return this.centreDeTri.afficherListeDepotsMenage(this.menageActuel);
	    }
	    
	    //TODO : front - trier par date et regrouper par date (jour) / sommer les activités d'une journée ex: nb de points par jour

	    public List<String> afficherListeCommerces() { 
	    	List<String> listeCommerces = new ArrayList<String>(); 
	    	for (Contrat contrat: this.centreDeTri.getListeContratsEnCours()) {
	    		if (contrat.getDateFin().isBefore(LocalDate.now())) {
	    			this.centreDeTri.ajouterContratPasse(contrat);
	    			this.centreDeTri.supprimerContratEnCours(contrat);
	    			
	    		}
	    		else if (contrat.getDateFin().isAfter(LocalDate.now())) {
	    		   listeCommerces.add(contrat.getCommerce());
	    	   }
	    		
	       } return listeCommerces; 
	    }


	    public BonAchat convertirPointsEnBon(String commerce) { 

	        Float nbPoints = this.menageActuel.getTotalPoints(); // initialize nbPoints for the connected menage 

	        if (nbPoints >= 50) { // check that menage has enough points to generate a bonAchat 
	            Integer valeurBon = Math.round(nbPoints / 50);

	            this.menageActuel.addPoints(Float.valueOf(-valeurBon * 50)); // update number points for menageActuel 
	            
	            String nomBonAchat = "Voucher for " + commerce + " - " + valeurBon * 10 + "$";
	            
	            // TODO : front - liste déroulante des commerces pour choisir dans lequel créer le bon
	            
	            BonAchat bonAchat = new BonAchat(nomBonAchat, this.menageActuel, commerce, valeurBon * 10); 
	            
	            this.listeBonAchats.add(bonAchat); 
	            
	            return bonAchat; 
	        } else {
	        	System.out.println("ERROR: You don't have enough points to generate a voucher. Points available :" + nbPoints);
	            return null; 
	        }
	    }
	    
	    public List<BonAchat> afficherNbBonAchat() {
	    	List<BonAchat> listeBonAchatsMenage = new ArrayList<BonAchat>();
	    	for (BonAchat bonAchat: this.listeBonAchats) {
	    		if (bonAchat.getMenage().equals(this.menageActuel)) {
	    			listeBonAchatsMenage.add(bonAchat);
	    		}
	    	} 
	    	return listeBonAchatsMenage; 
	    }

		public Menage getMenageActuel() {
			return menageActuel;
		}

		public void setMenageActuel(Menage menageActuel) {
			this.menageActuel = menageActuel;
		}
	}
