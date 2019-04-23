package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interface_graphique.FenetreChoixTraitements;


public class ListenerFenetreIndentification implements ActionListener {

		private JButton btnValider;
		private JTextField txtNomDutilisateur;
		private JTextField txtMotDePasse;
		private JButton btnQuitter;
		private FenetreChoixTraitements fct;
		
		public ListenerFenetreIndentification(FenetreChoixTraitements fct, JButton btnValider, JTextField txtNomDutilisateur, JTextField txtMotDePasse, JButton btnQuitter) {
			this.fct = fct;
			this.btnValider = btnValider;
			this.txtNomDutilisateur = txtNomDutilisateur;
			this.txtMotDePasse = txtMotDePasse;
			this.btnQuitter = btnQuitter;
		}
		
		@Override
		public void actionPerformed(ActionEvent evenement) {


		   /* How exactly do I mask the user input with asterisks preserving its original value?

		Use the JPasswordField which has nice function jPasswordField.getPassword(); to get the password as char[] to work with.

		    Use jPasswordField1.setEchoChar('*') to mask the password characters with *.
		    If you wish to see the value you are inserting use jPasswordField1.setEchoChar((char)0); Setting a value of 0 indicates 
		    that you wish to see the text as it is typed, similar to the behavior of a standard JTextField.*/

		    
			if (evenement.getSource() == btnValider) {
				if(txtNomDutilisateur.getText().equals("bobleprogrammeur") && txtMotDePasse.getText().equals("bob1234")) {
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
