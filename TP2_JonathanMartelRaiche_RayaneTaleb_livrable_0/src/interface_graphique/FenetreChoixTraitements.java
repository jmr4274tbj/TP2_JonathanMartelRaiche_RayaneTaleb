package interface_graphique;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FenetreChoixTraitements extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnArtistes;
	private JButton btnAlbums;
	private JButton btnQuitter;

	public FenetreChoixTraitements() {
		setTitle("Choix des traitements");
		setSize(300, 80);
		
		btnArtistes = new JButton("Artistes");

		btnAlbums = new JButton("Albums");

		btnQuitter = new JButton("Quitter");
		
		JPanel pan = new JPanel(new FlowLayout());    

		pan.add(btnArtistes);	
		pan.add(btnAlbums);	
		pan.add(btnQuitter);
			
		add(pan);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new FenetreChoixTraitements();
		fenetre.setVisible(true);
	}
	
}
