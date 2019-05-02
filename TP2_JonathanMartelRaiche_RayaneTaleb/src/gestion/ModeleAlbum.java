package gestion;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleAlbum extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// structure de donn�es
	private ArrayList<Album> lesDonnees;
	
	// ent�tes de colonnes
	private final String[] infos = {"No", "NoArtiste", "titre", "genre", "annee"};
	
	/**
	 * Construit un modeleAlbum � partir d'une liste de donn�es
	 * @param lesDonnes Structure de donn�es de type ArrayList
	 */
	public ModeleAlbum(ArrayList<Album> lesDonnees) {
		this.lesDonnees = lesDonnees;
		
	}
	
	/**
	 * Donne le nombre de colonnes dans le mod�le
	 *  Un JTable utilise cette m�thode pour d�terminer le nombre de colonne qu'il doit cr��er et afficher par d�faut
	 *  @return le nombre de colonne du mod�le
	 *  
	 */
	
	@Override
	public int getColumnCount() {	
		return infos.length;
	}

	/**
	 * Nombre de ligne dans le mod�le
	 * 
	 * Un JTable utilise cette m�thode pour d�terminer le nombre de lignes qu'il doit afficher
	 * @return le nombre de lignes du mod�le
	 */
	
	@Override
	public int getRowCount() {		
		return lesDonnees.size();
	}

	/**
	 * Renvoie la valeur de la cellule � rowIndex et colomnIndex
	 * @return valeur de l'objet � la position sp�cifi�e
	 * @param rowIndex : indice de la ligne
	 * @param columnIndex : indice de la colonne
	 * 
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch(columnIndex) {
		case 0 :
			return lesDonnees.get(rowIndex).getArtisteId();
		case 1 :
			return lesDonnees.get(rowIndex).getAlbumId();
		case 2 :
			return lesDonnees.get(rowIndex).getTitre();
		case 3 :
			return lesDonnees.get(rowIndex).getGenre();
		case 4 :
			return lesDonnees.get(rowIndex).getAnnee();

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
		return infos[columnIndex];
	}
	
	/**
	 * Renvoie la classe d'objets affich�s dans la colonne
	 * N�cessaire pour les rendus (renderers) associ�es � des type particulier
	 * 
	 */
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		   case 0: return String.class;
		   case 1: return String.class;
		   case 2: return String.class;
		   case 3: return String.class;
		   case 4: return String.class;
		   default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
		}
	}
	
}
