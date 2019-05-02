package gestion;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeleArtiste extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// structure de données
	private ArrayList<Artiste> lesDonnees;
	
	// entêtes de colonnes
	private final String[] lesTitres = {"No", "Nom", "Membre"};
	
	/**
	 * Construit un modeleArtiste à partir d'une liste de données
	 * @param lesDonnes Structure de données de type ArrayList
	 */
	public ModeleArtiste(ArrayList<Artiste> lesDonnees) {
		this.lesDonnees = lesDonnees;		
	}
	
	/**
	 * Donne le nombre de colonnes dans le modèle
	 *  Un JTable utilise cette méthode pour déterminer le nombre de colonne qu'il doit créer et afficher par défaut
	 *  @return le nombre de colonne du modèle
	 *  
	 */
	
	@Override
	public int getColumnCount() {
		return lesTitres.length;
	}

	/**
	 * Nombre de ligne dans le modèle
	 * 
	 * Un JTable utilise cette méthode pour déterminer le nombre de lignes qu'il doit afficher
	 * @return le nombre de lignes du modèle
	 */
	
	@Override
	public int getRowCount() {
		return lesDonnees.size();
	}

	/**
	 * Renvoie la valeur de la cellule à rowIndex et colomnIndex
	 * @return valeur de l'objet à la position spécifiée
	 * @param rowIndex : indice de la ligne
	 * @param columnIndex : indice de la colonne
	 * 
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0 :
			return lesDonnees.get(rowIndex).getArtisteId();
		case 1 :
			return lesDonnees.get(rowIndex).getNom();
		case 2 :
			return lesDonnees.get(rowIndex).isMembre();
		default :	
			return null;			
		}
		
	}

	/**
	 * retourne le nom de la colonne à l'indice columnIndex
	 * @return le nom de la colonne
	 * @param ColumnIndex: indice de la colonne
	 * 
	 */
	
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	
	/**
	 * Renvoie la classe de dobjets affichés dans la colonne
	 * Nécessaire pour les rendus (renderers) associées à des type particulier
	 * 
	 */
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		   case 0: return String.class;
		   case 1: return String.class;
		   case 2: return Boolean.class;
		   default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
	    }
	}
	
	public void ajouterArtiste(Artiste artiste) {
		lesDonnees.add(artiste);
		fireTableRowsInserted(lesDonnees.size() -1, lesDonnees.size() -1);
	}
	
	public void supprimerArtiste(int rowIndex) {
		lesDonnees.remove(rowIndex);
		// notification de la suppression de la ligne rowIndex à la ligne rowIndex
		fireTableRowsDeleted(rowIndex, rowIndex);
	}	
	
	public void modifierArtiste(int firstRow, Artiste artiste) {
		lesDonnees.set(firstRow, artiste);
		fireTableRowsUpdated(firstRow, firstRow);
	}

	// ==========================================================================
	// permet de mettre à jour le modèle avec une nouvelle ArrayListe
	// et d'informer les vues affichant ce modèle
	public void setDonnees(ArrayList<Artiste> nouvellesDonnees){
		lesDonnees = nouvellesDonnees;
		fireTableDataChanged();
	}
	// ==========================================================================
    //méthode utilisée pour accéder à un artiste à partir de son rang dans la table
	public Artiste getElement(int row){
		return lesDonnees.get(row);
	}
	
}
	
	
