package gestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestionAlbums {

	private Connection connection = ControleConnexion.getLaConnexion();  
	/**  
	 * Structure de données pour chercher la liste des albums de la BD 
	*/ 	
	private ArrayList<Album> listeAlbums; 
	 
	public GestionAlbums() {  
		listeAlbums = obtenirListeAlbums(); 
	} 
	
	public ArrayList<Album> getListeAlbums() {    
		return listeAlbums; 
	}  
	
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
	
}
