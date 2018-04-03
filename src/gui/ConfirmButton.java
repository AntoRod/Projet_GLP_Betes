package gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConfirmButton extends JButton{

	private static final long serialVersionUID = 5499172876582962282L;
	
	public ConfirmButton() {
		ImageIcon confirmIcon = new ImageIcon("assets/images/check_button.png");
		this.setIcon(confirmIcon);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
	}
	
	

}
