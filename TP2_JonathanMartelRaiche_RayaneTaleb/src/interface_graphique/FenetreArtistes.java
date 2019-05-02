package interface_graphique;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import gestion.ControleConnexion;
import gestion.GestionAlbums;
import gestion.GestionArtistes;
import gestion.ControleurFenetreArtistes;
import gestion.ControleurSelectionTableArtistes;
import gestion.ControleurDoubleClickTableArtistes;
import gestion.ModeleArtiste;
import gestion.RendererCentre;
import gestion.RendererGrasCentre;
import java.awt.Insets;
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
		setBounds(100, 100, 789, 576);
		getContentPane().setLayout(null);
		
		ControleConnexion.connecter();
		
		lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(20, 11, 168, 14);
		getContentPane().add(lblRechercherUnArtiste);
		
		txtRecherche = new JTextField();
		txtRecherche.setColumns(10);
		txtRecherche.setBounds(20, 36, 391, 30);
		getContentPane().add(txtRecherche);
		txtRecherche.setColumns(10);

		btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(421, 36, 117, 30);
		getContentPane().add(btnRecherche);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(638, 36, 117, 30);
		getContentPane().add(btnQuitter);
		
		lblArtistes = new JLabel("Artistes");
		lblArtistes.setBounds(20, 89, 150, 21);
		lblArtistes.setFont(new Font("Monospace", Font.BOLD, 15));
		getContentPane().add(lblArtistes);

		lblImageArtiste = new JLabel();
		lblImageArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageArtiste.setBounds(20, 121, 150, 150);
		getContentPane().add(lblImageArtiste);
		
		lblImageAlbum = new JLabel();
		lblImageAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageAlbum.setBounds(550, 352, 150, 150);
		getContentPane().add(lblImageAlbum);

		btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(35, 295, 117, 30);
		getContentPane().add(btnRemplacer);

		lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Monospace", Font.BOLD, 15));
		lblInformations.setBounds(20, 349, 186, 21);
		getContentPane().add(lblInformations);

		lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumro.setBounds(20, 390, 79, 21);
		getContentPane().add(lblNumro);

		lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setBounds(20, 419, 79, 21);
		getContentPane().add(lblNom);

		chckbxMembre = new JCheckBox();
		chckbxMembre.setEnabled(false);
		chckbxMembre.setBounds(69, 446, 21, 23);
		getContentPane().add(chckbxMembre);
			
		lblMembre = new JLabel("Membre");
		lblMembre.setHorizontalAlignment(SwingConstants.LEFT);
		lblMembre.setBounds(20, 448, 79, 21);
		getContentPane().add(lblMembre);

		txtNumro = new JTextField();
		txtNumro.setBounds(72, 391, 198, 20);
		txtNumro.setColumns(10);
		txtNumro.setEditable(false);
		getContentPane().add(txtNumro);

		txtNom = new JTextField();
		txtNom.setBounds(72, 419, 198, 20);
		txtNom.setColumns(10);
		txtNom.setEditable(false);
		getContentPane().add(txtNom);

		btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(638, 121, 117, 30);
		getContentPane().add(btnNouveau);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(638, 177, 117, 30);
		getContentPane().add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(638, 237, 117, 30);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(638, 295, 117, 30);
		getContentPane().add(btnSupprimer);
		
		modeleArtiste = new ModeleArtiste(gestionArtistes.getListeArtistes());
		jtableArtistes = new JTable(modeleArtiste);
		jtableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableArtistes.getColumnModel().getColumn(0).setCellRenderer(new RendererGrasCentre());
		jtableArtistes.getColumnModel().getColumn(1).setCellRenderer(new RendererCentre());
		scroListeArtistes = new JScrollPane();
		
		scroListeArtistes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroListeArtistes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroListeArtistes.setBounds(194, 121, 420, 204);
		getContentPane().add(scroListeArtistes);
		
		scroListeArtistes.setViewportView(jtableArtistes);
		
		modeleListeAlbums = new DefaultListModel<String>();
		jlistAlbums = new JList<String>(modeleListeAlbums);
		jlistAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroListeAlbums = new JScrollPane();
		
		scroListeAlbums.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroListeAlbums.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroListeAlbums.setBounds(292, 352, 198, 150);
		getContentPane().add(scroListeAlbums);
		
		scroListeAlbums.setViewportView(jlistAlbums);
	
		ControleurDoubleClickTableArtistes gestionTable = new ControleurDoubleClickTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		ControleurSelectionTableArtistes gestionSelectionTable = new ControleurSelectionTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		ControleurSelectionTableArtistes gestionSelectionListe = new ControleurSelectionTableArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums, gestionAlbums, gestionArtistes);
		
		ControleurFenetreArtistes gestion = new ControleurFenetreArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, lblImageAlbum, jtableArtistes, modeleArtiste);
		
		jtableArtistes.addMouseListener(gestionTable);
		jtableArtistes.getSelectionModel().addListSelectionListener(gestionSelectionTable);
		jlistAlbums.getSelectionModel().addListSelectionListener(gestionSelectionTable);
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
