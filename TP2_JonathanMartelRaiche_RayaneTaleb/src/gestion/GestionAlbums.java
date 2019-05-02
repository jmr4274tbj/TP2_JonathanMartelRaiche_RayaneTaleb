package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestionAlbums {

	private Connection connection = ControleConnexion.getLaConnexion();  
	/**  
	 * Structure de données pour chercher la liste des employés de la BD 
	*/ 	
	private ArrayList<Album> listeAlbums; 
	 
	public GestionAlbums() {  
		listeAlbums = obtenirListeAlbums(); 
	} 
	
	public ArrayList<Album> getListeAlbums() {    
		return listeAlbums; 
	}  
	
	/*
	public Album(int albumId, int artisteId, String titre, String genre, String annee, byte[] couverture ){
		this.artisteId = artisteId;
		this.albumId = albumId;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.couverture = couverture;
	}	
	public int getAlbumId() {
		return albumId;
	public int getArtisteId() {
		return artisteId;
	public String getTitre() {
		return titre;
	public String getGenre() {
		return genre;
	public String getAnnee() {
		return annee;
	public byte[] getCouverture() {
		return couverture;*/
	
	private ArrayList <Album> obtenirListeAlbums() {  
		ArrayList<Album> liste = new ArrayList <Album>();  
		
		String requete = "SELECT * FROM Albums ORDER BY albumId";
		
		try(Statement statement = connection.createStatement();
				ResultSet jeuResultats = statement.executeQuery(requete)) {
			while (jeuResultats.next()){
				
				int albumId = jeuResultats.getInt("albumId"); 
				int artisteId = jeuResultats.getInt("artisteId"); 
				String titre = jeuResultats.getString("titre"); 
				String genre = jeuResultats.getString("genre");  
				String annee = jeuResultats.getString("annee"); 
				byte[] couverture = jeuResultats.getBytes("couverture");
	     
				liste.add(new Album(albumId, artisteId, titre, genre, annee, couverture)); 
			}
		} catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null,          
			"Problème rencontr\u00E8 : " + sqle.getMessage(),   
			"Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}			
		
		return liste; 	
	} 
	
	public boolean ajouterAlbumBD(Album album) {  
		
		boolean boolAjout = false;  
			
		String requete = "INSERT INTO Albums VALUES (?,?,?,?,?,?)";
	    	
	    try(PreparedStatement statement = connection.prepareStatement(requete);){	
	        //Fixer les paramètres 
	    	statement.setInt(1, album.getAlbumId());
	    	statement.setInt(2, album.getArtisteId());
	    	statement.setString(3, album.getTitre());
	    	statement.setString(4, album.getGenre());
	    	statement.setString(5, album.getAnnee());
	    	statement.setBytes(6, album.getCouverture());
	    	statement.executeUpdate();
	    	boolAjout = true;  
	    		
	    } catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null, 
			"Problème rencontr\u00E8 lors de l'ajout de l'album : " 
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}				
		
		return boolAjout;  
	} 
	
	public boolean modifierAlbumBD(Album album) {
		boolean boolModif = false;  
		
		String requete = "UPDATE Albums SET nom = ?, membre = ?, photo = ? WHERE artisteId = ?"; // à modifier
    	
	    try(PreparedStatement statement = connection.prepareStatement(requete);){	
	        //Fixer les paramètres 
	    	statement.setInt(1, album.getAlbumId());
	    	statement.setInt(2, album.getArtisteId());
	    	statement.setString(3, album.getTitre());
	    	statement.setString(4, album.getGenre());
	    	statement.setString(5, album.getAnnee());
	    	statement.setBytes(6, album.getCouverture());
	    	statement.executeUpdate();
	    	boolModif = true;
	    		
	    } catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null, 
			"Problème rencontr\u00E8 lors de l'ajout de l'album : " 
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}			
		
		return boolModif; 	   
	} 
	
	public boolean supprimerAlbumBD(Album album) {
		boolean boolSupp = false;  		
            	
		String requete = "DELETE FROM Albums WHERE albumId = " + album.getAlbumId();       

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolSupp = true; //Suppression réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la suppression de l'album : "                
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}
		
		return boolSupp;	   
	} 
	
}
