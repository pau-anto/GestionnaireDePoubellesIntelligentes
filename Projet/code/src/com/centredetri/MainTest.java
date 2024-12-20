package com.centredetri;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args)  {
		CentreDeTri centreDeTri = new CentreDeTri("epita", "6 rue du faubourg st george"); 
		Application application = new Application(centreDeTri); 
		
		centreDeTri.ajouterMenage("maxou01", "12345");
		application.creerCompte("popo", "pau24");
		application.creerCompte("popo", "pop25");
		application.login("popo", "pau24");
		application.getMenageActuel();
		
		List<TypeDechet> listeDechets = new ArrayList<TypeDechet>();
		listeDechets.add(TypeDechet.PLASTIQUE);
		centreDeTri.ajouterPoubelle(listeDechets,  "rue st Lazarre");
		
		String dateStr = "04/12/2027";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
		String commerceTest = "Machine à pain";
		centreDeTri.ajouterContratEnCours(parsedDate, "Machine à pain");
		
		Poubelle poubelle = centreDeTri.getListePoubelles().getFirst();
		
		poubelle.ajouterDepot(application.getMenageActuel(), 1f,  TypeDechet.PAPIER);
		System.out.println(application.getMenageActuel().getTotalPoints());
		
		poubelle.ajouterDepot(application.getMenageActuel(), 190f,  TypeDechet.PLASTIQUE);
		poubelle.ajouterDepot(application.getMenageActuel(), 200f,  TypeDechet.PLASTIQUE);
		
		System.out.println(application.getMenageActuel().getTotalPoints());
		
		BonAchat bonAchat = application.convertirPointsEnBon(commerceTest);
        if (bonAchat != null) {
            System.out.println("Voucher created !");
        }
        
        System.out.println(application.getMenageActuel().getTotalPoints());
		
	}
}
	
