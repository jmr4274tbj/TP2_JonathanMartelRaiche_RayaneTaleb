package gestion;

import java.sql.Blob;

public class Artiste {
	private int artisteId;
	private String nom;
	private String membre;
	private Blob photo;
	
	//Constructeur
	public Artiste(int artisteId, String nom, String membre, Blob photo ){
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

	public String getMembre() {
		return membre;
	}
	
	public Blob getPhoto() {
		return photo;
	}

}