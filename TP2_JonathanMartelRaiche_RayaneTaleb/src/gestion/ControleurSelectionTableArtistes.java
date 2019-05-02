package gestion;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ControleurSelectionTableArtistes implements ListSelectionListener {

		private JCheckBox chckbxMembre;
		private JTextField txtNumro;
		private JTextField txtNom;
		private JLabel lblImageArtiste;
		private JTable jtableArtistes;
		private ModeleArtiste modeleArtiste;
		private JList<String> jlistAlbums;
		private DefaultListModel<String> modeleListeAlbums;
		
		
		public ControleurSelectionTableArtistes(JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom,  
				JLabel lblImageArtiste, JTable jtableArtistes, ModeleArtiste modeleArtiste, 
				DefaultListModel<String> modeleListeAlbums, JList<String> jlistAlbums) {
			this.chckbxMembre = chckbxMembre;
			this.txtNumro = txtNumro;
			this.txtNom = txtNom;
			this.lblImageArtiste = lblImageArtiste;
			this.jtableArtistes = jtableArtistes;
			this.modeleArtiste = modeleArtiste;
			this.jlistAlbums = jlistAlbums;
			this.modeleListeAlbums = modeleListeAlbums;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {			        
			int numLigne;
			Artiste artiste;
			
			modeleListeAlbums.clear();
	        
	        GestionAlbums gestion = new GestionAlbums();
	        
	        ArrayList<Album> listeAlbums = gestion.getListeAlbums();
			
			if(jtableArtistes.getSelectedRow() != -1) {
				numLigne = jtableArtistes.getSelectedRow();
				artiste = modeleArtiste.getElement(numLigne);
				
				txtNumro.setText(String.valueOf(artiste.getArtisteId()));
		        txtNom.setText(artiste.getNom());	 		          	                
		        lblImageArtiste.setIcon(new ImageIcon(new ImageIcon(artiste.getPhoto())
		        		.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));          
		          
		        if(artiste.isMembre()) { 
		        	chckbxMembre.setSelected(true);  
		        } else { 
		        	chckbxMembre.setSelected(false);  
		        } 
		        
		        for(int index = 0; index < listeAlbums.size(); index++) {
		        	  
		            Album album = listeAlbums.get(index);
		        	  
		        	if(album.getArtisteId() == artiste.getArtisteId()) {
		        		  
		        		modeleListeAlbums.addElement(album.getAnnee() + " - " + album.getTitre());
		        	}
		        }
		        
		        jlistAlbums.setSelectedIndex(0);
			}	             
	        
		}

}
