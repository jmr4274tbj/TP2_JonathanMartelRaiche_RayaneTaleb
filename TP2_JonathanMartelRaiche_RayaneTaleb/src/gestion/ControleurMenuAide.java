package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ControleurMenuAide implements ActionListener {
	
	private JButton btnAide;
	
	public ControleurMenuAide(JButton btnAide) { 
		this.btnAide =  btnAide;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  btnAide) {
			
		}
	}

}
