package core;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuBuilder extends JFrame{
	
	
	private Image background = Toolkit.getDefaultToolkit().getImage("assets/images/menu.jpg");
	
	public MenuBuilder () {
		//this.paintComponent(this.getGraphics());
	}
	
	
	public void setBackground(Image fond) {
		background = fond;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		this.setBackground(background);
		g.drawImage(background, 0, 0, this);
	}
	
}