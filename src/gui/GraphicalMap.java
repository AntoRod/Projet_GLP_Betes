package gui;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;

import data.*;

public class GraphicalMap extends JFrame{
	
	private static final long serialVersionUID = 15601560412569849L;
	
	public GraphicalMap() {
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap(String title) {
		super(title);
		
		initMap();
		
	}
	

	
	public void initMap() {
		
		/*TOUT les elements de l'interface*/
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		GridLayout mapLayout = new GridLayout(MapParameters.MAP_WIDTH, MapParameters.MAP_WIDTH);
		
		/*TOUT ce qui concerne la GridLayout*/
		
		for (int i=0;i<MapParameters.MAP_WIDTH;i++) {
			for (int j=0;j<MapParameters.MAP_WIDTH;j++) {
				add(new MapPanel());
				
			}
		}
		
		/*TOUT ce qui concerne le Container de la map*/
		Container mapContent = getContentPane();
		mapContent.setPreferredSize(MapParameters.CASE_DIMENSION);
		mapContent.setLayout(mapLayout);
		
		
		/*TOUT ce qui concerne la barre de Menu de la Map*/
		menuBar = new JMenuBar();
		menu = new JMenu("test menu");
		menu.getAccessibleContext().setAccessibleDescription("description");
		menuBar.add(menu);
		menuItem = new JMenuItem("A text-only menu item",KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem);
		
		this.setJMenuBar(menuBar);
		
		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

}

