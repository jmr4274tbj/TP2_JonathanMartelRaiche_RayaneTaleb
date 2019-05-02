package gestion;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ControleurSelectionListeArtistes implements ListSelectionListener {

		private JLabel lblImageAlbum;
		private JTable jtableArtistes;
		private ModeleArtiste modeleArtiste;	
		
		public ControleurSelectionListeArtistes(JLabel lblImageAlbum, JTable jtableArtistes, ModeleArtiste modeleArtiste) {

			this.lblImageAlbum = lblImageAlbum;
			this.jtableArtistes = jtableArtistes;
			this.modeleArtiste = modeleArtiste;

		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {			        
	        
			int numLigne = jtableArtistes.getSelectedRow();
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
	        		  
	        }
	        
	        
		}

}
