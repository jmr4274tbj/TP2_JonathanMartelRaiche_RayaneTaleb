package interface_graphique;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FenetreArtistes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblRechercherUnArtiste;
	private JTextField txtRecherche;
	private JButton btnRecherche;
	private JButton btnQuitter;
	private JLabel lblArtistes;
	private JLabel lblImageArtiste;
	private JButton btnRemplacer;
	private JLabel lblInformations;
	private JLabel lblNumro;
	private JLabel lblNom;
	private JCheckBox chckbxMembre;
	private JLabel lblMembre;
	private JTextField txtNumro;
	private JTextField txtNom;
	private JButton btnNouveau;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JLabel lblImageAlbum;
	private static JTable jtableArtistes;
	private static JList<String> jlistAlbums = new JList<String>();
	private static JScrollPane scroListeArtistes = new JScrollPane(jlistAlbums);

	public FenetreArtistes() {
		setTitle("Gestion des artistes");
		setSize(903, 565);
		
		lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		
		txtRecherche = new JTextField();
		txtRecherche.setText("The");
		txtRecherche.setColumns(10);

		btnRecherche = new JButton("Recherche");
		
		btnQuitter = new JButton("Quitter");
		
		lblArtistes = new JLabel("Artistes");

		lblImageArtiste = new JLabel("Image");

		btnRemplacer = new JButton("Remplacer");

		lblInformations = new JLabel("Informations");

		lblNumro = new JLabel("Num\u00E9ro");

		lblNom = new JLabel("Nom");

		chckbxMembre = new JCheckBox("");
		
		lblMembre = new JLabel("Membre");

		txtNumro = new JTextField();
		txtNumro.setText("Num\u00E9ro");
		txtNumro.setColumns(10);

		txtNom = new JTextField();
		txtNom.setText("Nom");
		txtNom.setColumns(10);

		btnNouveau = new JButton("Nouveau");

		btnAjouter = new JButton("Ajouter");

		btnModifier = new JButton("Modifier");

		btnSupprimer = new JButton("Supprimer");

		lblImageAlbum = new JLabel("Image");

		jtableArtistes = new JTable();
		
		JPanel pan = new JPanel(new GridBagLayout());    
		GridBagConstraints gbc = new GridBagConstraints();
		  	   
	    gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0;
		gbc.weighty = 0;	
	
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 2;
		gbc.gridy = 1;
		pan.add(lblRechercherUnArtiste, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 2;
		pan.add(txtRecherche, gbc);

		gbc.gridx = 4;
		gbc.gridy = 2;
		pan.add(btnRecherche, gbc);

		gbc.gridx = 9;
		gbc.gridy = 2;	
		pan.add(btnQuitter, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		pan.add(lblArtistes, gbc);
		
		gbc.gridx = 9;
		gbc.gridy = 4;
		pan.add(btnNouveau, gbc);	

		gbc.gridx = 2;
		gbc.gridy = 5;
		pan.add(lblImageArtiste, gbc);
		
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 3;
		gbc.gridy = 5;
		pan.add(jtableArtistes, gbc);

		gbc.gridx = 9;
		gbc.gridy = 5;
		pan.add(btnAjouter, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		pan.add(btnRemplacer, gbc);	

		gbc.gridx = 9;
		gbc.gridy = 6;
		pan.add(btnModifier, gbc);	

		gbc.gridx = 9;
		gbc.gridy = 7;
		pan.add(btnSupprimer, gbc);		

		gbc.gridx = 2;
		gbc.gridy = 9;
		pan.add(lblInformations, gbc);	

		gbc.gridx = 9;
		gbc.gridy = 9;
		pan.add(lblImageAlbum, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 2;
		gbc.gridy = 10;
		pan.add(lblNumro, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 3;
		gbc.gridy = 10;
		pan.add(txtNumro, gbc);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 4;
		gbc.gridy = 10;
		pan.add(jlistAlbums, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 2;
		gbc.gridy = 11;
		pan.add(lblNom, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 3;
		gbc.gridy = 11;
		pan.add(txtNom, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 12;
		pan.add(lblMembre, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 12;
		pan.add(chckbxMembre, gbc);

		add(pan);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new FenetreArtistes();
		fenetre.setVisible(true);
	}
	
}
