package gestion;

import java.sql.*;

import javax.swing.JOptionPane;

public class ControleConnexion {
	/**  
	 * L'int�r�t d'une connexion statique est de disposer d'une connexion unique durant toute une session.  
	*/

	private static Connection laConnexion; 
	private static String  url = "jdbc:sqlite:sqlite/db/biblioteque_musicale.db";
	
	/** 
	 * �tablit la connexion � la BDD si elle n'existe pas. Attention, la connexion ne doit pas �tre ferm�e 
	*/	
	public static void connecter() {  
		try{   
			if(laConnexion == null || laConnexion.isClosed()) {      
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
				Class.forName("org.sqlite.JDBC");
				laConnexion = DriverManager.getConnection(url);    
				JOptionPane.showMessageDialog(null, "Connect\u00E9 � la BD", "ALERTE", JOptionPane.INFORMATION_MESSAGE);    
			}    
		
		} catch(ClassNotFoundException e) { 
			System.out.println("ERREUR : " + e);
			
		} catch(SQLException sqle) {        
			System.out.println("ERREUR : " + sqle);
		}   
	} 
	  
	public static void fermerSession(){  
		try{   
			if (laConnexion != null && !laConnexion.isClosed()) {
				laConnexion.close();
			} 
		}  
		catch(SQLException sqle){ 
			System.out.println("ERREUR SQL : " + sqle);
		} 
	} 
	
	public static Connection getLaConnexion() {
		ControleConnexion.connecter();
		return laConnexion; 	
	} 
	
	
	/*//POUR TESTER
	public static void main(String args[]) {
		connecter();
	}*/
	
	 

}