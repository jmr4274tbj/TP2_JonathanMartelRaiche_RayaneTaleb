package gestion;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import interface_graphique.FenetreArtistes;


public class ControleurFenetreArtistes implements ActionListener {

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
		
		public ControleurFenetreArtistes(JTextField txtRecherche, JButton btnRecherche, JButton btnQuitter, 
				JButton btnRemplacer, JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom, 
				JButton btnNouveau, JButton btnAjouter, JButton btnModifier, JButton btnSupprimer, 
				JLabel lblImageArtiste, JLabel lblImageAlbum, JTable jtableArtistes, ModeleArtiste modeleArtiste) {
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
			this.modeleArtiste = modeleArtiste;;
		}
		
		@Override
		public void actionPerformed(ActionEvent evenement) {
			
			if (evenement.getSource() == btnRecherche) {		
				
				
			} else if (evenement.getSource() == btnNouveau) {
				txtNumro.setText(String.valueOf(modeleArtiste.getRowCount()+1)); //AUTO INCREMENT
				txtNom.setText("");
				txtNom.setEditable(true);
				chckbxMembre.setSelected(false);
				chckbxMembre.setFocusable(true);
				ImageIcon image = new ImageIcon(FenetreArtistes.class.getResource("images_artistes/image_artiste_default.png"));
				lblImageArtiste.setIcon(image);
				
			} else if (evenement.getSource() == btnAjouter ){
				
				try{
					
					int numero = Integer.parseInt(txtNumro.getText());
					String nom = txtNom.getText();
					boolean membre = chckbxMembre.isSelected();
					
					Icon icon = lblImageArtiste.getIcon();			
					BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();			
					icon.paintIcon(null, g, 0,0);
					g.dispose();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(bi, "png", baos );
					byte[] photo = baos.toByteArray();
					
					Artiste artiste = new Artiste(numero, nom, membre, photo);	

					GestionArtistes gestionnaire = new GestionArtistes();
					
					if (gestionnaire.ajouterArtisteBD(artiste)){
						modeleArtiste.ajouterArtiste(artiste);
						viderChamps();
					}		
					
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Le num�ro n'est pas un nombre");
				} catch (IOException e) {
					e.printStackTrace();
				}		
				
			} else if (evenement.getSource() == btnQuitter) {
				
				int reponse = JOptionPane.showConfirmDialog(null,
						"�tes-vous s�r de vouloir quitter l'application?",
						"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(reponse == 0) {
					System.exit(0);
				}
				
			} else if (evenement.getSource() == btnModifier ) {
				int numLigne = -1;
				numLigne = jtableArtistes.getSelectedRow();
				
				if(numLigne != -1){
					
					try {
						
						int numero = Integer.parseInt(txtNumro.getText());
						String nom = txtNom.getText();
						boolean membre = chckbxMembre.isSelected();
						
						Icon icon = lblImageArtiste.getIcon();			
						BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
						Graphics g = bi.createGraphics();			
						icon.paintIcon(null, g, 0,0);
						g.dispose();
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(bi, "png", baos );
						byte[] photo = baos.toByteArray();
						
						Artiste artiste = new Artiste(numero, nom, membre, photo);	
	
						GestionArtistes gestionnaire = new GestionArtistes();
						
						if (gestionnaire.modifierArtisteBD(artiste)){
							modeleArtiste.modifierArtiste(numLigne, artiste);
							//viderChamps();
						}	
						
						if (modeleArtiste.getRowCount() == 0) {
			            	btnModifier.setEnabled(false);
			            } else {
			            	btnModifier.setEnabled(true);
			            }
						
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Le num�ro n'est pas un nombre");
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
				
				// si aucune ligne s�lectionn�e
			    if(numLigne == -1) {
			       JOptionPane.showMessageDialog(null, "S�lectionnez une ligne avant.",
			            "Suppression", JOptionPane.INFORMATION_MESSAGE);
			    }

			} else if (evenement.getSource() == btnSupprimer ) {
				int numLigne1 = -1;
				numLigne1 = jtableArtistes.getSelectedRow();
				
				if(numLigne1 != -1){						
        		          	
					GestionArtistes gestionnaire = new GestionArtistes();
					
					//getValueAt(int rowIndex, int columnIndex);
					Artiste artiste1 = modeleArtiste.getElement(numLigne1);
					
					if (gestionnaire.supprimerArtisteBD(artiste1)){
						modeleArtiste.supprimerArtiste(numLigne1);
					}
					
		            if (modeleArtiste.getRowCount() == 0) {
		            	btnSupprimer.setEnabled(false);
		            } else {
		            	btnSupprimer.setEnabled(true);
		            }
				}		
				
				// si aucune ligne s�lectionn�e
		        if(numLigne1 == -1) {
		            JOptionPane.showMessageDialog(null, "S�lectionnez une ligne avant.",
		            		"Suppression", JOptionPane.INFORMATION_MESSAGE);
		        }
			} 
	}
			

		private void viderChamps() {
			txtNumro.setText(String.valueOf(modeleArtiste.getRowCount()+1)); //AUTO INCREMENT
			txtNom.setText("");
			chckbxMembre.setSelected(false);
			ImageIcon image = new ImageIcon(FenetreArtistes.class.getResource("image_artiste_default.png"));
			lblImageArtiste.setIcon(image);
			
		}

}
