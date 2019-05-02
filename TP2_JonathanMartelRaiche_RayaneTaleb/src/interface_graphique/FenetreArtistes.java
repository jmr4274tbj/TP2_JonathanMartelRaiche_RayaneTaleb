package interface_graphique;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import gestion.ControleConnexion;
import gestion.GestionArtistes;
import gestion.ControleurFenetreArtistes;
import gestion.ControleurMenuAide;
import gestion.ControleurSelectionListeArtistes;
import gestion.ControleurSelectionTableArtistes;
import gestion.ControleurDoubleClickTableArtistes;
import gestion.ModeleArtiste;
import gestion.RendererCentre;
import gestion.RendererGrasCentre;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class FenetreArtistes extends JDialog {

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
	private JTable jtableArtistes;	
	private DefaultListModel<String> modeleListeAlbums;
	private JList<String> jlistAlbums;	
	private JScrollPane scroListeArtistes;
	private JScrollPane scroListeAlbums;
	private ModeleArtiste modeleArtiste;
	private GestionArtistes gestionArtistes = new GestionArtistes();
	private JButton btnAide;

	public FenetreArtistes(FenetreChoixTraitements parent) {
		super( parent, true );
		setTitle("Gestion des artistes");
		setBounds(100, 100, 789, 597);
		getContentPane().setLayout(null);
		
		ControleConnexion.connecter();
		
		lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(22, 45, 168, 14);
		getContentPane().add(lblRechercherUnArtiste);
		
		txtRecherche = new JTextField();
		txtRecherche.setColumns(10);
		txtRecherche.setBounds(22, 70, 391, 30);
		getContentPane().add(txtRecherche);
		txtRecherche.setColumns(10);

		btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(423, 70, 117, 30);
		getContentPane().add(btnRecherche);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(640, 70, 117, 30);
		getContentPane().add(btnQuitter);
		
		lblArtistes = new JLabel("Artistes");
		lblArtistes.setBounds(22, 123, 150, 21);
		lblArtistes.setFont(new Font("Monospace", Font.BOLD, 15));
		getContentPane().add(lblArtistes);

		lblImageArtiste = new JLabel();
		lblImageArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageArtiste.setBounds(22, 155, 150, 150);
		getContentPane().add(lblImageArtiste);
		
		lblImageAlbum = new JLabel();
		lblImageAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageAlbum.setBounds(552, 386, 150, 150);
		getContentPane().add(lblImageAlbum);

		btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(37, 329, 117, 30);
		getContentPane().add(btnRemplacer);

		lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Monospace", Font.BOLD, 15));
		lblInformations.setBounds(22, 383, 186, 21);
		getContentPane().add(lblInformations);

		lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumro.setBounds(22, 424, 79, 21);
		getContentPane().add(lblNumro);

		lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setBounds(22, 453, 79, 21);
		getContentPane().add(lblNom);

		chckbxMembre = new JCheckBox();
		chckbxMembre.setEnabled(false);
		chckbxMembre.setBounds(71, 480, 21, 23);
		getContentPane().add(chckbxMembre);
			
		lblMembre = new JLabel("Membre");
		lblMembre.setHorizontalAlignment(SwingConstants.LEFT);
		lblMembre.setBounds(22, 482, 79, 21);
		getContentPane().add(lblMembre);

		txtNumro = new JTextField();
		txtNumro.setBounds(74, 425, 198, 20);
		txtNumro.setColumns(10);
		txtNumro.setEditable(false);
		getContentPane().add(txtNumro);

		txtNom = new JTextField();
		txtNom.setBounds(74, 453, 198, 20);
		txtNom.setColumns(10);
		txtNom.setEditable(false);
		getContentPane().add(txtNom);

		btnNouveau = new JButton("Nouveau");
		btnNouveau.setBounds(640, 155, 117, 30);
		getContentPane().add(btnNouveau);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(640, 211, 117, 30);
		getContentPane().add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(640, 271, 117, 30);
		getContentPane().add(btnModifier);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(640, 329, 117, 30);
		getContentPane().add(btnSupprimer);
		
		btnAide = new JButton("Aide");
		btnAide.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAide);
		
		modeleArtiste = new ModeleArtiste(gestionArtistes.getListeArtistes());
		jtableArtistes = new JTable(modeleArtiste);
		jtableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableArtistes.getColumnModel().getColumn(0).setCellRenderer(new RendererGrasCentre());
		jtableArtistes.getColumnModel().getColumn(1).setCellRenderer(new RendererCentre());
		scroListeArtistes = new JScrollPane();
		
		scroListeArtistes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroListeArtistes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroListeArtistes.setBounds(196, 155, 420, 204);
		getContentPane().add(scroListeArtistes);
		
		scroListeArtistes.setViewportView(jtableArtistes);
		
		modeleListeAlbums = new DefaultListModel<String>();
		jlistAlbums = new JList<String>(modeleListeAlbums);
		jlistAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroListeAlbums = new JScrollPane();
		
		scroListeAlbums.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroListeAlbums.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroListeAlbums.setBounds(294, 386, 198, 150);
		getContentPane().add(scroListeAlbums);
		
		scroListeAlbums.setViewportView(jlistAlbums);
	
		ControleurDoubleClickTableArtistes gestionTable = new ControleurDoubleClickTableArtistes(chckbxMembre, txtNumro, txtNom);
		
		ControleurSelectionTableArtistes gestionSelectionTable = new ControleurSelectionTableArtistes(chckbxMembre, txtNumro, txtNom, lblImageArtiste, jtableArtistes, modeleArtiste, modeleListeAlbums, jlistAlbums);
		
		ControleurSelectionListeArtistes gestionSelectionListe = new ControleurSelectionListeArtistes(lblImageAlbum, jtableArtistes, modeleArtiste);
		
		ControleurFenetreArtistes gestion = new ControleurFenetreArtistes(txtRecherche, btnRecherche, btnQuitter, 
				btnRemplacer, chckbxMembre, txtNumro, txtNom, btnNouveau, btnAjouter, btnModifier, btnSupprimer, 
				lblImageArtiste, jtableArtistes, modeleArtiste);
		
		ControleurMenuAide gestionAide = new ControleurMenuAide(btnAide);
		
		jtableArtistes.addMouseListener(gestionTable);
		jtableArtistes.getSelectionModel().addListSelectionListener(gestionSelectionTable);
		jlistAlbums.getSelectionModel().addListSelectionListener( gestionSelectionListe);
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
		btnAide.addActionListener(gestionAide); 
		
		setResizable(false);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
	}	
}
