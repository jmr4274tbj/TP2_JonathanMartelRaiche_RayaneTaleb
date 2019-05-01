package gestion;

public class Artiste {
	private int artisteId;
	private String nom;
	private boolean membre;
	private byte[] photo;
	
	//Constructeur
	public Artiste(int artisteId, String nom, boolean membre, byte[] photo){
		this.artisteId = artisteId;
		this.nom = nom;
		this.membre = membre;
		this.photo = photo;
	}
	
	//Constructeur pour la recherche et la suppression par numéro d'artiste
	public Artiste(int numero ){
		this.artisteId = numero;
		this.nom = "";
	}
	
	public int getArtisteId() {
		return artisteId;
	}

	public String getNom() {
		return nom;
	}

	public boolean isMembre(){
		return this.membre;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

}