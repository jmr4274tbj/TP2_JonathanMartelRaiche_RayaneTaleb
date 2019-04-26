package interface_graphique;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import gestion.Artiste;
import gestion.ControleConnexion;
import gestion.GestionArtistes;
import gestion.ListenerFenetreArtistes;
import gestion.ModeleArtiste;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FenetreArtistes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblRechercherUnArtiste;
	private JTextField txtRecherche;
	private JButton btnRecherche;
	private JButton btnQuitter;
	private JLabel lblArtistes;
	private JLabel lblImageArtiste;
	private ImageIcon image;
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
	//private static DefaultListModel<String> modelAlbums;
	private static JList<String> jlistAlbums = new JList<String>();
	private static JScrollPane scroListeArtistes;
	private ModeleArtiste modeleArtiste;
	private GestionArtistes gestionArtiste = new GestionArtistes();
	//private FenetreChoixTraitements parent;

	public FenetreArtistes(FenetreChoixTraitements parent) {
		super( parent, true );
		setTitle("Gestion des artistes");
		setSize(1200, 1200);
		//this.parent = parent;
		
		lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		
		txtRecherche = new JTextField();
		txtRecherche.setText("The");
		txtRecherche.setColumns(10);

		btnRecherche = new JButton("Recherche");
		
		btnQuitter = new JButton("Quitter");
		
		lblArtistes = new JLabel("Artistes");

		lblImageArtiste = new JLabel();
		//lblImageArtiste.setPreferredSize(new Dimension(30, 30));
		// TEST
		image = new ImageIcon(ListenerFenetreArtistes.class.getResource("image_artiste_default.png"));
		lblImageArtiste.setIcon(image);
		// FIN TEST

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

		lblImageAlbum = new JLabel();		
		//lblImageAlbum.setPreferredSize(new Dimension(30, 30));
		// TEST
		lblImageAlbum.setIcon(image);
		// FIN TEST
		
		ControleConnexion.connecter();
		modeleArtiste = new ModeleArtiste(gestionArtiste.getListeArtistes());
		jtableArtistes = new JTable(modeleArtiste);
		jtableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroListeArtistes = new JScrollPane(jtableArtistes);

		
		JPanel pan = new JPanel(new GridBagLayout());    
		GridBagConstraints gbc = new GridBagConstraints();
		  	   
	    gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0;
		gbc.weighty = 0;	
	
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
		pan.add(scroListeArtistes, gbc);

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
		
		ListenerFenetreArtistes gestion = new ListenerFenetreArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste);
		txtRecherche.addActionListener(gestion);
		btnRecherche.addActionListener(gestion); 
		btnQuitter.addActionListener(gestion); 
		btnRemplacer.addActionListener(gestion); 
		chckbxMembre.addActionListener(gestion);
		txtNumro.addActionListener(gestion); 
		txtNom.addActionListener(gestion); 
		btnNouveau.addActionListener(gestion); 
		btnAjouter.addActionListener(gestion); 
		btnModifier.addActionListener(gestion); 
		btnSupprimer.addActionListener(gestion); 
		
		setResizable(true);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
	}
	
}
