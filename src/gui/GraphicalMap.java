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

import core.*;

import java.awt.Graphics;

import data.*;

public class GraphicalMap extends JFrame{
	
	private static final long serialVersionUID = 15601560412569849L;
	
	private Container mapContent = null;
	private MapPanel mapPanel;
	private MenuPanel menuPanel;
	private MapBuilder mapBuilder;
	private Moving movement;
	
	public GraphicalMap() throws InterruptedException {
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap(String title) throws InterruptedException {
		super(title);
		try {
			initMap();
			while(true) {
				
				movement = new Moving();
				/*for(int i=0;i<Map_Settings.nbBeasts;i++) {
					System.out.println(mapPanel.getBeast(i).getLocation());
				}*/
				
				
				Thread.sleep(500);
				for(int i=0;i<Map_Settings.nbBeasts;i++) {
					movement.Move(mapPanel.getBeast(i), Map_Settings.generateRand(1, 4));
				}
				
				this.resetBeastImages();
				mapPanel = mapBuilder.setBeastImages(mapPanel);
				
			}
		} catch(IOException e) {e.getMessage();}
		
	}


	public void initMap() throws IOException, InterruptedException {
		
		/*TOUT les elements de l'interface*/
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		
		GridLayout GUILayout = new GridLayout(Map_Settings.MAP_WIDTH, Map_Settings.MAP_LENGTH);
		
		mapContent = getContentPane();
		mapContent.setPreferredSize(Map_Settings.GUI_DIMENSION);
		mapContent.setLayout(GUILayout);
		
		
		/*TOUT ce qui concerne le Container de la map*/

		
		initMapPanel();	
		addMapPanel();
	
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
		//this.setContentPane(mapBuilder);
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				//mapContent.add(mapPanel.getTilePanel(i,j));
				mapContent.add(mapPanel.getTilePanel(i,  j), i*Map_Settings.MAP_WIDTH+j);
			}
		}
	}
	
	public void resetBeastImages() {
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				mapPanel.getTilePanel(i,  j).setBeastImage(null);
				repaint();
			}
		}
	}
	

}

