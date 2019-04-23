package gestion;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeleArtiste extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// structure de donn�es
	private ArrayList<Artiste> lesDonnees;
	
	// ent�tes de colonnes
	
	private final String[] lesTitres = {"No", "Nom", "Membre"};
	
	/**
	 * Construit un modeleEmploy� � partir d'une liste de donn�es
	 * @param lesDonnes Structure de donn�es de type ArrayList
	 */
	public ModeleArtiste(ArrayList<Artiste> lesDonnees) {
		this.lesDonnees = lesDonnees;
		
	}
	
	/**
	 * Donne le nombre de colonnes dans le mod�le
	 *  Un JTable utilise cette m�thode pour d�terminer le nombre de colonne qu'il doit cr��er et afficher poar d�fau
	 *  @return le nombre de colonne du mod�le
	 *  
	 */
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}

	/**
	 * Nombre de ligne dans le mod�le
	 * 
	 * Un JTable utilise cette m�thode pour d�terminer le nombre de lignes qu'il doit afficher
	 * @return le nombre de lignes du mod�le
	 */
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesDonnees.size();
	}

	/**
	 * Renvoie la valeur de la cellule � rowIndex et colomnIndex
	 * @return vakleur de l'objet � la position sp�cifi�e
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
			return lesDonnees.get(rowIndex).getMembre();

		default :	
			return null;
			
		}
		
	}

	/**
	 * retourne le nom de la colonne � l'indice columnIndex
	 * @return le nom de la colonne
	 * @param ColumnIndex: indice de la colonne
	 * 
	 */
	
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	
	/**
	 * Renvoie la classe de dobjets affich�s dans la colonne
	 * N�cessaire pour les rendus (renderers) associ�es � des type particulier
	 * 
	 */
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		   case 0: return String.class;
		   case 1: return String.class;
		   case 2: return String.class;
		   default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
	    }
	}

	public void ajouterArtiste(Artiste artiste) {
		lesDonnees.add(artiste);	
	}
	
}
	
	
