package gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import core.MenuBuilder;

public class MenuPanel extends JPanel{
	
	private Image background;

	private static final long serialVersionUID = 8475751505006519027L;
	
	public MenuPanel() {
		background = Toolkit.getDefaultToolkit().getImage("assets/images/menu.jpg");
	}
	public MenuPanel(String imagePath) {
		background = Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	
	public Image getBackgroundImage() {
		return background;
	}
	


}
