package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interface_graphique.FenetreChoixTraitements;


public class ControleurFenetreIndentification implements ActionListener {

		private JButton btnValider;
		private JTextField txtNomDutilisateur;
		private JPasswordField txtMotDePasse;
		private JButton btnQuitter;
		private FenetreChoixTraitements fct;
		
		public ControleurFenetreIndentification(FenetreChoixTraitements fct, JButton btnValider, JTextField txtNomDutilisateur, JPasswordField txtMotDePasse, JButton btnQuitter) {
			this.fct = fct;
			this.btnValider = btnValider;
			this.txtNomDutilisateur = txtNomDutilisateur;
			this.txtMotDePasse = txtMotDePasse;
			this.btnQuitter = btnQuitter;
		}
		
		@Override
		public void actionPerformed(ActionEvent evenement) {
			
			if (evenement.getSource() == btnValider) {
				if(txtNomDutilisateur.getText().equals("bobprogrammeur") && String.valueOf(txtMotDePasse.getPassword()).equals("bob1234")) {
					fct.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect!",  "Erreur", JOptionPane.ERROR_MESSAGE);
				}

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
