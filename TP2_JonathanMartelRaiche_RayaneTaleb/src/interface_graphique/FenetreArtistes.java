package interface_graphique;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestion.Album;
import gestion.Artiste;
import gestion.ControleConnexion;
import gestion.GestionAlbums;
import gestion.GestionArtistes;
import gestion.ControleurFenetreArtistes;
import gestion.ControleurSelectionTableArtistes;
import gestion.ControleurClickTableArtistes;
import gestion.ModeleArtiste;
import gestion.RendererCentre;
import gestion.RendererGrasCentre;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
	private JTable jtableArtistes;
	
	private DefaultListModel<String> modeleListeAlbums;
	private JList<String> jlistAlbums;
	
	private JScrollPane scroListeArtistes;
	private JScrollPane scroListeAlbums;
	private ModeleArtiste modeleArtiste;
	//private ModeleAlbum modeleAlbum;
	private GestionArtistes gestionArtistes = new GestionArtistes();
	private GestionAlbums gestionAlbums = new GestionAlbums();

	public FenetreArtistes(FenetreChoixTraitements parent) {
		super( parent, true );
		setTitle("Gestion des artistes");
		setSize(1000, 1000);
		//this.parent = parent;
		
		ControleConnexion.connecter();
		
		lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		
		txtRecherche = new JTextField();
		txtRecherche.setColumns(10);

		btnRecherche = new JButton("Recherche");
		
		btnQuitter = new JButton("Quitter");
		
		lblArtistes = new JLabel("Artistes");

		lblImageArtiste = new JLabel();
		//lblImageArtiste.setPreferredSize(new Dimension(30, 30));
		// TEST
		image = new ImageIcon(FenetreArtistes.class.getResource("images_artistes/image_artiste_default.png"));
		lblImageArtiste.setIcon(image);
		// FIN TEST
		
		lblImageAlbum = new JLabel();
		//lblImageArtiste.setPreferredSize(new Dimension(30, 30));
		// TEST
		image = new ImageIcon(FenetreArtistes.class.getResource("images_albums/image_album_default.png"));
		lblImageAlbum.setIcon(image);
		// FIN TEST

		btnRemplacer = new JButton("Remplacer");

		lblInformations = new JLabel("Informations");

		lblNumro = new JLabel("Num\u00E9ro");

		lblNom = new JLabel("Nom");

		chckbxMembre = new JCheckBox("");
		chckbxMembre.setFocusable(false);
		
		
		lblMembre = new JLabel("Membre");

		txtNumro = new JTextField();
		txtNumro.setText("Num\u00E9ro");
		txtNumro.setColumns(10);
		txtNumro.setEditable(false);

		txtNom = new JTextField();
		txtNom.setText("Nom");
		txtNom.setColumns(10);
		txtNom.setEditable(false);

		btnNouveau = new JButton("Nouveau");

		btnAjouter = new JButton("Ajouter");

		btnModifier = new JButton("Modifier");

		btnSupprimer = new JButton("Supprimer");

		lblImageAlbum = new JLabel();		
		//lblImageAlbum.setPreferredSize(new Dimension(30, 30));
		// TEST
		lblImageAlbum.setIcon(image);
		// FIN TEST
		
		modeleArtiste = new ModeleArtiste(gestionArtistes.getListeArtistes());
		jtableArtistes = new JTable(modeleArtiste);
		jtableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableArtistes.getColumnModel().getColumn(0).setCellRenderer(new RendererGrasCentre());
		jtableArtistes.getColumnModel().getColumn(1).setCellRenderer(new RendererCentre());
		scroListeArtistes = new JScrollPane(jtableArtistes);
		
		modeleListeAlbums = new DefaultListModel<String>();
		jlistAlbums = new JList<String>(modeleListeAlbums);
		jlistAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroListeAlbums = new JScrollPane(jlistAlbums);
		
		ControleurClickTableArtistes gestionTable = new ControleurClickTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		ControleurSelectionTableArtistes gestionSelectionTable = new ControleurSelectionTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		ControleurSelectionTableArtistes gestionSelectionListe = new ControleurSelectionTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		jtableArtistes.addMouseListener(gestionTable);
		jtableArtistes.getSelectionModel().addListSelectionListener(gestionSelectionTable);
		
		jlistAlbums.getSelectionModel().addListSelectionListener(gestionSelectionListe);	
		
		
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
		
		ControleurFenetreArtistes gestion = new ControleurFenetreArtistes(txtRecherche, btnRecherche, btnQuitter, 
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
