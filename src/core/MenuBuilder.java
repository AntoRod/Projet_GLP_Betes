package core;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MenuBuilder extends JComponent{
	
	
	private Image background = null;
	
	public MenuBuilder () {
	}
	
	public void setBackground(Image fond) {
		background = fond;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(background);
		g.drawImage(background, 0, 0, this);
	}
	

}
