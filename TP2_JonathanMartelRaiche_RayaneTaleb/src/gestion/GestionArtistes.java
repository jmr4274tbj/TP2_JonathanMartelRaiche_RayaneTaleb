package gestion;

import java.sql.Blob;
import java.sql.Connection;
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
		
		// Pour MEMBRE Oui = 1 Non = 0
		try(Statement statement = connection.createStatement();   
				ResultSet jeuResultat= statement.executeQuery(requete)) {    
			while(jeuResultat.next()) {           
				int artisteId = jeuResultat.getInt("artisteId");      
				String nom = jeuResultat.getString("nom");   
				int membre = jeuResultat.getInt("membre");      
				Blob photo = jeuResultat.getBlob("photo");
     
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
		
		String requete = "INSERT INTO Artistes(artisteId, nom, membre, photo) VALUES('"     
				+ artiste.getArtisteId() + "','"      
				+ artiste.getNom() + ",'"     
				+ artiste.getMembre() + "',"  
				+ artiste.getPhoto() + "',"    
				+ ")";  

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolAjout = true; //L'ajout réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de l'enregistrement de l'artiste : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolAjout;  
	} 
	
	public boolean modifierArtisteBD(Artiste artiste) {
		boolean boolModif = false;  
		
		String requete = "UPDATE Artistes SET "
				+"nom = " + artiste.getNom()
				+ ", membre = " + artiste.getMembre()
				+ ", photo = " + artiste.getPhoto()
				+ " WHERE id = " + artiste.getArtisteId();   

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolModif = true; //Modification réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la modification de l'artiste : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolModif; 	   
	} 
	
	public boolean supprimerArtisteBD(Artiste artiste) {
		boolean boolSupp = false;  
		
		String requete = "DELETE FROM Artistes WHERE id = " + artiste.getArtisteId();       

		try {   
			Statement statement = connection.createStatement();   
			statement.executeUpdate(requete);   
			boolSupp = true; //Suppression réussi   
			
		} catch (SQLException sqle){          
			JOptionPane.showMessageDialog(null,      
			"Probl\u00E8me rencontr\u00E9 lors de la suppression de l'artiste : "                
			+ sqle.getMessage(),"Résultat", JOptionPane.ERROR_MESSAGE);  
		} 
		
		return boolSupp;	   
	} 
	
	// POUR TESTER
	/*public static void main(String[] args) {
		
	}*/
}
