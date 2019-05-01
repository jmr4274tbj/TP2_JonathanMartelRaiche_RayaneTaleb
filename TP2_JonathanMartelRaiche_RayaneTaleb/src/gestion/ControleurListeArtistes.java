package gestion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ControleurListeArtistes implements MouseListener {

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
		private Connection connection = ControleConnexion.getLaConnexion(); 
		
		public ControleurListeArtistes(JTextField txtRecherche, JButton btnRecherche, JButton btnQuitter, 
				JButton btnRemplacer, JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom, 
				JButton btnNouveau, JButton btnAjouter, JButton btnModifier, JButton btnSupprimer, 
				JLabel lblImageArtiste, JLabel lblImageAlbum, JTable jtableArtistes, ModeleArtiste modeleArtiste, JList<String> jlistAlbums) {
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
		}
		
		@Override
		public void mouseClicked(MouseEvent e) { 
	          int numLigne; 	        
	          numLigne = jtableArtistes.getSelectedRow();
	          Artiste artiste = modeleArtiste.getElement(numLigne);//méthode ajoutée
	          
	          txtNumro.setText(String.valueOf(artiste.getArtisteId()));
	          txtNom.setText(artiste.getNom());	 	     
	          
	          if(artiste.isMembre()) { 
	        	  chckbxMembre.setSelected(true);  
	          } else { 
	        	  chckbxMembre.setSelected(false);  
	          }  
	          
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub		
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub		
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub		
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub			
		}

}
