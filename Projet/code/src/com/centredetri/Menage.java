package com.centredetri;

import java.util.Objects;

public class Menage{
	private int idUser;
	private String nom; 
	private String adresse; 
	private Float totalPoints;
	private String username;
	private String password;
	
	
	public Integer getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUserName(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Float getTotalPoints() {
		return totalPoints;
	}

	public void addPoints(Float points) {
		this.totalPoints += points;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Menage(int idUser, String username, String password) {
		this.username = username;
		this.password = password; 
		this.totalPoints = 0f;
	}

	public boolean equals(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menage other = (Menage) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
}
