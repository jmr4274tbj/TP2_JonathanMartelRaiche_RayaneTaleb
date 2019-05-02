package gestion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class ControleurDoubleClickTableArtistes implements MouseListener {

		private JCheckBox chckbxMembre;
		private JTextField txtNumro;
		private JTextField txtNom;
		
		
		public ControleurDoubleClickTableArtistes(JCheckBox chckbxMembre, JTextField txtNumro, JTextField txtNom) {
			this.chckbxMembre = chckbxMembre;
			this.txtNumro = txtNumro;
			this.txtNom = txtNom;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {

	        if (e.getClickCount() == 2 && !e.isConsumed()) {
	            e.consume();
	            //handle double click event.
	            txtNumro.setEditable(false);
		        txtNom.setEditable(true);	 	              
		        chckbxMembre.setEnabled(true);           
	       } else {
	    	   txtNumro.setEditable(false);
		       txtNom.setEditable(false);	 	              
		       chckbxMembre.setEnabled(false);
	       }
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

}
