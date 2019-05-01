package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestionArtistes {

	private Connection connection = ControleConnexion.getLaConnexion();  
	/**  
	 * Structure de données pour chercher la liste des employés de la BD 
	*/ 	
	private ArrayList<Artiste> listeArtistes; 
	 
	public GestionArtistes() {  
		listeArtistes = obtenirListeArtistes(); 
	} 
	
	public ArrayList<Artiste> getListeArtistes() {    
		return listeArtistes; 
	}  
	
	private ArrayList <Artiste> obtenirListeArtistes() {  
		ArrayList<Artiste> liste = new ArrayList <Artiste>();  
		
		String requete = "SELECT * FROM Artistes ORDER BY artisteId";
		
		try(Statement statement = connection.createStatement();
				ResultSet jeuResultats = statement.executeQuery(requete)) {
			while (jeuResultats.next()){
				int artisteId = jeuResultats.getInt("artisteId");      
				String nom = jeuResultats.getString("nom");   
				boolean membre = jeuResultats.getBoolean("membre");      
				byte[] photo = jeuResultats.getBytes("photo");
	     
				liste.add(new Artiste(artisteId, nom, membre, photo)); 
			}
		} catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null,          
			"Problème rencontr\u00E8 : " + sqle.getMessage(),   
			"Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}			
		
		return liste; 	
	} 
	
	public boolean ajouterArtisteBD(Artiste artiste) {  
		
		boolean boolAjout = false;  
			
		String requete = "INSERT INTO Artistes VALUES (?,?,?,?)";
	    	
	    try(PreparedStatement statement = connection.prepareStatement(requete);){	
	        //Fixer les paramètres 
	    	statement.setInt(1, artiste.getArtisteId());
	    	statement.setString(2, artiste.getNom());
	    	statement.setBoolean(3, artiste.isMembre());
	    	statement.setBytes(4, artiste.getPhoto());
	    	statement.executeUpdate();
	    	boolAjout = true;  
	    		
	    } catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null, 
			"Problème rencontr\u00E8 lors de l'ajout de l'artiste : " 
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}				
		
		return boolAjout;  
	} 
	
	public boolean modifierArtisteBD(Artiste artiste) {
		boolean boolModif = false;  
		
		String requete = "UPDATE Artistes SET nom = ?, membre = ?, photo = ? WHERE artisteId = ?"; 
    	
	    try(PreparedStatement statement = connection.prepareStatement(requete);){	
	        //Fixer les paramètres 
	    	statement.setString(2, artiste.getNom());
	    	statement.setBoolean(3, artiste.isMembre());
	    	statement.setBytes(4, artiste.getPhoto());
	    	statement.setInt(1, artiste.getArtisteId());
	    	statement.executeUpdate();
	    	boolModif = true;
	    		
	    } catch (SQLException sqle) {   
			JOptionPane.showMessageDialog(null, 
			"Problème rencontr\u00E8 lors de l'ajout de l'artiste : " 
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}			
		
		return boolModif; 	   
	} 
	
	public boolean supprimerArtisteBD(Artiste artiste) {
		boolean boolSupp = false;  		
            	
		String requete = "DELETE FROM Artistes WHERE artisteId = " + artiste.getArtisteId();       

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolSupp = true; //Suppression réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la suppression de l'artiste : "                
			+ sqle.getMessage(), "Résultat", JOptionPane.ERROR_MESSAGE);  
			sqle.printStackTrace();
		}
		
		return boolSupp;	   
	} 
	
}
