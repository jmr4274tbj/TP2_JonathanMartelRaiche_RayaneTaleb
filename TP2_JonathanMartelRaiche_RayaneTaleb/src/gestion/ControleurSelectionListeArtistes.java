package gestion;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interface_graphique.FenetreArtistes;


public class ControleurSelectionListeArtistes implements ListSelectionListener {

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
		private DefaultListModel<String> modeleListeAlbums;
		
		
		public ControleurSelectionListeArtistes(JTextField txtRecherche, JButton btnRecherche, JButton btnQuitter, 
				JButton btnRemplacer, JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom, 
				JButton btnNouveau, JButton btnAjouter, JButton btnModifier, JButton btnSupprimer, 
				JLabel lblImageArtiste, JLabel lblImageAlbum, JTable jtableArtistes, ModeleArtiste modeleArtiste, 
				DefaultListModel<String> modeleListeAlbums, JList<String> jlistAlbums, GestionAlbums gestionAlbums, GestionArtistes gestionArtistes) {
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
			this.modeleListeAlbums = modeleListeAlbums;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {			        
	        
			/*int numLigne = jtableArtistes.getSelectedRow();
	        Artiste artiste = modeleArtiste.getElement(numLigne);    	        
	        
	        //Affichage de la couverture de l'album sélectionné
	        
	        GestionAlbums gestion = new GestionAlbums();
	          
	        ArrayList<Album> listeAlbums = gestion.getListeAlbums();	      

	        for(int index = 0; index < listeAlbums.size(); index++) {
	        	  
	            Album album = listeAlbums.get(index);
	        	  
	        	if(album.getArtisteId() == artiste.getArtisteId()) {
	        		lblImageAlbum.setIcon(new ImageIcon(new ImageIcon(album.getCouverture())
	    	        		.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
	        	}
	        		  
	        }*/
		}

}
