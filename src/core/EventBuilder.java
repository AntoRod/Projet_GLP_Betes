package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventBuilder {
	
	public EventBuilder() {
		
	}
	
	class Play implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			System.out.print("CECI EST UN TEST\n");
		}
	}
	
	
	
	

}
