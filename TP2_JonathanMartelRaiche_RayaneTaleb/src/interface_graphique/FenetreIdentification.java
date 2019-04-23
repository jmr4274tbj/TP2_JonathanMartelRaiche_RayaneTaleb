package interface_graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import gestion.ListenerFenetreIndentification;
import javax.swing.JButton;
import java.awt.Font;


public class FenetreIdentification extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNomDutilisateur;
	private JLabel lblMotDePasse;
	private JLabel lblConnexionLapplication;
	private JButton btnValider;
	private JTextField txtNomDutilisateur;
	private JTextField txtMotDePasse;
	private JButton btnQuitter;
	private FenetreChoixTraitements fct = new FenetreChoixTraitements(this);

	/**
	 * Create the frame.
	 */
	public FenetreIdentification() {
		setTitle("Gestion des Albums");
		setSize(425, 220);
		
		lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblConnexionLapplication = new JLabel("Connexion \u00E0 l'application");
		lblConnexionLapplication.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtNomDutilisateur = new JTextField(10);
		txtNomDutilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomDutilisateur.setText("bobleprogrammeur");
		//txtNomDutilisateur.setColumns(10);

		txtMotDePasse = new JTextField(10);
		txtMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMotDePasse.setText("bob1234");
		//txtMotDePasse.setColumns(10);

		btnValider = new JButton("Valider");
		btnQuitter = new JButton("Quitter");
		
		JPanel pan = new JPanel(new GridBagLayout());    
		GridBagConstraints gbc = new GridBagConstraints();;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		//gbc.weightx = 0; gbc.weighty = 0;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		pan.add(lblConnexionLapplication, gbc);	

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		pan.add(lblNomDutilisateur, gbc);	

		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		pan.add(txtNomDutilisateur, gbc);	

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		pan.add(lblMotDePasse, gbc);	

		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		pan.add(txtMotDePasse, gbc);	
	
		add(pan);
		setLayout(new FlowLayout()); 
		add(btnValider);	
		add(btnQuitter);	
		
		ListenerFenetreIndentification gestion = new ListenerFenetreIndentification(fct, btnValider, txtNomDutilisateur, txtMotDePasse, btnQuitter);
		btnValider.addActionListener(gestion);
		txtNomDutilisateur.addActionListener(gestion);
		txtMotDePasse.addActionListener(gestion);
		btnQuitter.addActionListener(gestion);
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
}