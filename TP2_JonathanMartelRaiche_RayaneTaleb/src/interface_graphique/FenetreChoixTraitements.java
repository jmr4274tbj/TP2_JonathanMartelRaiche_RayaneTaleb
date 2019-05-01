package interface_graphique;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import gestion.ControleurFenetreChoixTraitements;
import javax.swing.JButton;
import javax.swing.JDialog;


public class FenetreChoixTraitements extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnArtistes;
	private JButton btnAlbums;
	private JButton btnQuitter;
	//private FenetreIdentification parent;
	private FenetreArtistes fa = new FenetreArtistes(this);

	public FenetreChoixTraitements(FenetreIdentification parent) {
		super( parent, true );
		setTitle("Choix des traitements");
		setSize(300, 80);
		//this.parent = parent;
		
		btnArtistes = new JButton("Artistes");

		btnAlbums = new JButton("Albums");

		btnQuitter = new JButton("Quitter");
		
		JPanel pan = new JPanel(new FlowLayout());    

		pan.add(btnArtistes);	
		pan.add(btnAlbums);	
		pan.add(btnQuitter);
			
		add(pan);
		
		ControleurFenetreChoixTraitements gestion = new ControleurFenetreChoixTraitements(fa, btnArtistes, btnAlbums, btnQuitter);
		btnArtistes.addActionListener(gestion);
		btnAlbums.addActionListener(gestion);
		btnQuitter.addActionListener(gestion);
		
		setResizable(true);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	}
	
}
