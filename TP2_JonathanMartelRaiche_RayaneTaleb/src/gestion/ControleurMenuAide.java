package gestion;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;


public class ControleurMenuAide implements ActionListener {
	
	private JButton btnAide;
	
	public ControleurMenuAide(JButton btnAide) { 
		this.btnAide =  btnAide;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  btnAide) {
			try{
				File fleFichier= new File("c:Documentation.chm");
				Desktop.getDesktop().open(fleFichier);
			} catch(IOException msg) {
				System.out.println(msg);	
			}
		}
	}

}
