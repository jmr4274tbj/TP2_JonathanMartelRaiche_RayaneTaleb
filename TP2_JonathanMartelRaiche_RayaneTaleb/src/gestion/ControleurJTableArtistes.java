package gestion;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ControleurJTableArtistes implements MouseListener {

		private JTextField txtRecherche;
		private JButton btnRecherche;
		private JButton btnQuitter;
		private JButton btnRemplacer;
		private JCheckBox chckbxMembre;
		private JTextField txtNumro;
		private JTextField txtNom;
		private JButton btnNouveau;
		private JButton btnAjouter;
		private JButton btnModifier;
		private JButton btnSupprimer;
		private JLabel lblImageArtiste;
		private JLabel lblImageAlbum;
		private JTable jtableArtistes;
		private ModeleArtiste modeleArtiste;
		private JList<String> jlistAlbums;
		private GestionAlbums gestionAlbums;
		private GestionArtistes gestionArtistes;
		
		
		public ControleurJTableArtistes(JTextField txtRecherche, JButton btnRecherche, JButton btnQuitter, 
				JButton btnRemplacer, JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom, 
				JButton btnNouveau, JButton btnAjouter, JButton btnModifier, JButton btnSupprimer, 
				JLabel lblImageArtiste, JLabel lblImageAlbum, JTable jtableArtistes, ModeleArtiste modeleArtiste, 
				JList<String> jlistAlbums, GestionAlbums gestionAlbums, GestionArtistes gestionArtistes) {
			this.txtRecherche = txtRecherche;
			this.btnRecherche = btnRecherche;
			this.btnQuitter = btnQuitter;
			this.btnRemplacer = btnRemplacer;
			this.chckbxMembre = chckbxMembre;
			this.txtNumro = txtNumro;
			this.txtNom = txtNom;
			this.btnNouveau = btnNouveau;
			this.btnAjouter = btnAjouter;
			this.btnModifier = btnModifier;
			this.btnSupprimer = btnSupprimer;
			this.lblImageArtiste = lblImageArtiste;
			this.lblImageAlbum = lblImageAlbum;
			this.jtableArtistes = jtableArtistes;
			this.modeleArtiste = modeleArtiste;
			this.jlistAlbums = jlistAlbums;
			this.gestionAlbums = gestionAlbums;
			this.gestionArtistes = gestionArtistes;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) { 
	          int numLigne; 	        
	          numLigne = jtableArtistes.getSelectedRow();
	          Artiste artiste = modeleArtiste.getElement(numLigne);//méthode ajoutée
	          
	          txtNumro.setText(String.valueOf(artiste.getArtisteId()));
	          txtNom.setText(artiste.getNom());	 		          	                
	          lblImageArtiste.setIcon(new ImageIcon(new ImageIcon(artiste.getPhoto()).getImage()));          
	          
	          if(artiste.isMembre()) { 
	        	  chckbxMembre.setSelected(true);  
	          } else { 
	        	  chckbxMembre.setSelected(false);  
	          }      	         
		  	
		}

		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {

	        if (e.getClickCount() == 2 && !e.isConsumed()) {
	            e.consume();
	            //handle double click event.
	            txtNumro.setEditable(false);
		        txtNom.setEditable(true);	 	              
		        chckbxMembre.setFocusable(true);           
	       } else {
	    	   txtNumro.setEditable(false);
		       txtNom.setEditable(false);	 	              
		       chckbxMembre.setFocusable(false);
	       }
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

}
