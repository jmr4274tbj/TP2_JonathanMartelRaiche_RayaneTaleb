package gestion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestionAlbums {

	private  Connection connection = ControleConnexion.getLaConnexion();  
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
	
	private ArrayList<Album> obtenirListeAlbums() {  
		ArrayList<Album> liste = new ArrayList <Album>();  
		String requete = "SELECT * FROM Albums ORDER BY albumId";  
		
		try(Statement statement = connection.createStatement();   
				ResultSet jeuResultat= statement.executeQuery(requete)) {    
			while(jeuResultat.next()) {      
				int albumId = jeuResultat.getInt("albumId");      
				int artisteId = jeuResultat.getInt("artisteId");      
				String titre = jeuResultat.getString("titre");   
				String genre = jeuResultat.getString("genre");      
				String annee = jeuResultat.getString("annee");
				byte[] couverture = jeuResultat.getBytes("couverture");
     
				liste.add(new Album(albumId, artisteId, titre, genre, annee, couverture));     
			} 	
		} catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null,          
			"Problème rencontr\u00E8 : " + sqle.getMessage(),   
			"Résultat", JOptionPane.ERROR_MESSAGE);  
		}
		
		return liste; 	
	} 
	
	public boolean ajouterAlbumBD(Album album) {  
 
		boolean boolAjout = false;  
		
		String requete = "INSERT INTO Albums(albumId, artisteId, titre, genre, annee, couverture) VALUES('"     
				+ album.getAlbumId() + "','"  
				+ album.getArtisteId() + "',"     
				+ album.getTitre() + ",'"     
				+ album.getGenre() + "',"  
				+ album.getAnnee() + "',"
				+ album.getCouverture() + "',"    
				+ ")";  

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolAjout = true; //L'ajout réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de l'enregistrement de l'album : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolAjout;  
	} 
	
	public boolean modifierAlbumBD(Album album) {
		boolean boolModif = false;  
		
		String requete = "UPDATE Albums SET " 
				+ "artisteId = " + album.getArtisteId() 
				+", titre = " + album.getTitre()
				+ ", genre = " + album.getGenre()
				+ ", annee = " + album.getAnnee()
				+ ", couverture = " + album.getCouverture() 
				+ " WHERE id = " + album.getAlbumId();   

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolModif = true; //Modification réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la modification de l'album : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolModif; 	   
	} 
	
	public boolean supprimerAlbumBD(Album album) {
		boolean boolSupp = false;  
		
		String requete = "DELETE FROM Albums WHERE id = " + album.getAlbumId();       

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolSupp = true; //Suppression réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la suppression de l'album : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolSupp; 	   
	} 
	
	// POUR TESTER
	/*public static void main(String[] args) {
	 
	}*/

}
