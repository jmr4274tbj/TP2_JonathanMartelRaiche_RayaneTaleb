package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import interface_graphique.FenetreArtistes;


public class ControleurFenetreChoixTraitements implements ActionListener {

		private JButton btnArtistes;
		private JButton btnAlbums;
		private JButton btnQuitter;
		private FenetreArtistes fa;
		
		public ControleurFenetreChoixTraitements(FenetreArtistes fa, JButton btnArtistes, JButton btnAlbums, JButton btnQuitter) {
			this.fa = fa;
			this.btnArtistes = btnArtistes;
			this.btnAlbums = btnAlbums;
			this.btnQuitter = btnQuitter;
		}
		
		@Override
		public void actionPerformed(ActionEvent evenement) {
			
			if (evenement.getSource() == btnArtistes) {		
				fa.setVisible(true);
				
			} else if (evenement.getSource() == btnAlbums) {
				//afficher fenêtre album BONUS
				
			} else if (evenement.getSource() == btnQuitter) {
				int reponse = JOptionPane.showConfirmDialog(null,
						"Êtes-vous sûr de vouloir quitter l'application?",
						"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(reponse == 0) {
					System.exit(0);
				}
			}

	}

}
