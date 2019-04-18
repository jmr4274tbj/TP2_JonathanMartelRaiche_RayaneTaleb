package gestion;

import java.sql.*;

import javax.swing.JOptionPane;

public class ControleConnexion {
	/**  
	 * L'intérêt d'une connexion statique est de disposer d'une connexion unique durant toute une session.  
	 */

	private static Connection laConnexion; 
	//private static String  url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=c:/bd/employes.accdb"; 
	private static String  url = "jdbc:sqlite:sqlite/db/biblioteque_musicale.db";
	
	/** 
	 * Établit la connexion à la BDD si elle n'existe pas. Attention, la connexion ne doit pas être fermée 
	 */	
	public static void connecter() {  
		try{   
			if(laConnexion == null || laConnexion.isClosed()) {      
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
			Class.forName("org.sqlite.JDBC");
			laConnexion= DriverManager.getConnection(url);    
			JOptionPane.showMessageDialog(null, "Connect\u00E9 à la BD", "ALERTE",                      
					JOptionPane.INFORMATION_MESSAGE);    
			}    
		
		} catch(ClassNotFoundException e) { 
			System.out.println("ERREUR : " + e);
			
		} catch(SQLException sqle) {        
			System.out.println("ERREUR : " + sqle);
		}   
	} 
	  
	public static void fermerSession(){  
		try{   
			if (laConnexion!=null  && !laConnexion.isClosed()) {
				laConnexion.close();
			} 
		}  
		catch(SQLException sqle){ 
			System.out.println("ERREUR SQL : " + sqle);
		} 
	} 
	
	public static Connection getLaConnexion() {
		return laConnexion; 
		
	} 
	
	//POUR TESTER
	public static void main(String args[]) {
		connecter();
	}
	 

}
