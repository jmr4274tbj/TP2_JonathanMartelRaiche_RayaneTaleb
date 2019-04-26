package gestion;

import java.sql.Blob;

public class Artiste {
	private int artisteId;
	private String nom;
	private int membre;
	private byte[] photo;
	
	//Constructeur
	public Artiste(int artisteId, String nom, int membre, byte[] photo){
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

	public int getMembre() {
		return membre;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

}