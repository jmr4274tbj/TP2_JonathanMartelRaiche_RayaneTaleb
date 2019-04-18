package gestion;

import java.sql.Blob;

public class Artiste {
	private int artisteId;
	private String nom;
	private boolean membre;
	private Blob photo;
	
	//Constructeur
	public Artiste(int artisteId, String nom, boolean membre, Blob photo){
		this.artisteId = artisteId;
		this.nom = nom;
		this.membre = membre;
		this.photo = photo;
	}
	
	public int getArtisteId() {
		return artisteId;
	}

	public String getNom() {
		return nom;
	}

	public boolean getMembre() {
		return membre;
	}
	
	public Blob getPhoto() {
		return photo;
	}

}