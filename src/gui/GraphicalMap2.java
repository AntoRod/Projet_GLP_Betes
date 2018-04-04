package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

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

import core.MapBuilder;
import core.MenuBuilder;
import core.Moving;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import data.*;
public class GraphicalMap2 extends JFrame{
	
	private static final long serialVersionUID = 15601560412569849L;
	
	private Container mapContent = null;
	private MapPanel mapPanel;
	private MenuPanel menuPanel;
	private MapBuilder mapBuilder;
	private MenuBuilder menuBuilder;
	private JPanel mapJPanel;
	private Moving movement;
	
	public GraphicalMap2() throws InterruptedException {
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap2(String title) throws InterruptedException {
		super(title);
		
		try {
			initMap();
			
			
		} catch(IOException e) {e.getMessage();}
		
		
	}
	
	public void initMap() throws IOException, InterruptedException {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		
		GridBagLayout GUILayout = new GridBagLayout();
		GridLayout MapLayout = new GridLayout(Map_Settings.MAP_WIDTH, Map_Settings.MAP_LENGTH);
		
		
		mapContent = getContentPane();
		mapContent.setPreferredSize(Map_Settings.GUI_DIMENSION);
		
		mapContent.setLayout(GUILayout);
		mapJPanel = new JPanel();
		mapJPanel.setPreferredSize(Map_Settings.MAP_DIMENSION);
		mapJPanel.setLayout(MapLayout);
		
		initMapPanel();
		addMapPanel();
		
		
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
	
	
	public void initMapPanel() {
		this.setContentPane(this.getContentPane());
		mapBuilder = new MapBuilder(mapPanel);
		mapPanel = new MapPanel();
		//setRandomMap(width of the map, length)
		mapPanel = mapBuilder.setRandomMap(mapPanel);
		mapPanel = mapBuilder.setRandomBeasts(mapPanel);
		mapPanel = mapBuilder.setTileImages(mapPanel);
		for (int i=0;i<Map_Settings.nbBeasts;i++) {
			mapPanel.getBeastPanel().get(i).setBeastImage();
		}
		/*try {
			mapPanel = mapBuilder.setBeastImages2(mapPanel);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		mapPanel = mapBuilder.setBeastImages(mapPanel);
		
		
		
	}
	
	public void addMapPanel() {
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				//mapContent.add(mapPanel.getTilePanel(i,j));
				mapJPanel.add(mapPanel.getTilePanel(i,  j), i*Map_Settings.MAP_WIDTH+j);
			}
		}
		mapContent.add(mapJPanel);
	}
	

}