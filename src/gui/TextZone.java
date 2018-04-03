package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class TextZone extends JTextField{

	private static final long serialVersionUID = 3501832954415946313L;
	
	public TextZone(int columns, Font font) {
		this.setColumns(columns);
		this.setFont(font);
	}
	
	

}
