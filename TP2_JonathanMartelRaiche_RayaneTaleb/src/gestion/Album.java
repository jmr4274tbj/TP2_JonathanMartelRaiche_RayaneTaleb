package gestion;

import java.sql.Blob;

public class Album {
	private int artisteId;
	private int albumId;
	private String titre;
	private String genre;
	private String annee;
	private Blob couverture;
	
	//Constructeur
	public Album(int albumId, int artisteId, String titre, String genre, String annee, Blob couverture ){
		this.artisteId = artisteId;
		this.albumId = artisteId;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.couverture = couverture;
	}
	
	public int getAlbumId() {
		return albumId;
	}
	
	public int getArtisteId() {
		return artisteId;
	}

	public String getTitre() {
		return titre;
	}

	public String getGenre() {
		return genre;
	}
	
	public String getAnnee() {
		return annee;
	}
	
	public Blob getCouverture() {
		return couverture;
	}

}