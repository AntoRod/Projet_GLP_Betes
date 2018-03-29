package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import core.EventBuilder;
import core.MapBuilder;
import core.MenuBuilder;
import core.Moving;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import data.*;
public class GraphicalMap3 extends JFrame{
	
	private static final long serialVersionUID = 15601560412569849L;
	
	private Container mapContent = null;
	private MapPanel mapPanel;
	private MenuPanel menuPanel;
	private MapBuilder mapBuilder;
	private MenuBuilder menuBuilder;
	private EventBuilder eventBuilder;
	private JPanel mapJPanel;
	private JPanel menuJPanel;
	private JPanel settingsJPanel;
	private Moving movement;
	
	public GraphicalMap3() throws InterruptedException {
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap3(String title) throws InterruptedException {
		super(title);
		
		try {
			//initialisation of the panels/containers/layouts
			initComponents();
			
			initMenu();
			
			
			//initMap();
			packLayout();
		} catch(IOException e) {e.getMessage();}
		
		
	}
	
	public void initMap() throws IOException, InterruptedException {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		

		
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
		

		
	}
	
	
	public void initComponents() {
		GridBagLayout GUILayout = new GridBagLayout();
		GridLayout MapLayout = new GridLayout(Map_Settings.MAP_WIDTH, Map_Settings.MAP_LENGTH);
		FlowLayout menuLayout = new FlowLayout();
		
		mapContent = getContentPane();
		mapContent.setPreferredSize(Map_Settings.GUI_DIMENSION);
		mapContent.setLayout(GUILayout);
		
		mapJPanel = new JPanel();
		mapJPanel.setPreferredSize(Map_Settings.MAP_DIMENSION);
		mapJPanel.setLayout(MapLayout);
		mapPanel = new MapPanel();
		mapBuilder = new MapBuilder(mapPanel);
		
		menuPanel = new MenuPanel();
		menuBuilder = new MenuBuilder();
		menuJPanel = new JPanel();
		settingsJPanel = new JPanel();
		
		menuJPanel.setBackground(Color.RED);
		menuJPanel.setLayout(GUILayout);
		menuJPanel.setPreferredSize(Map_Settings.GUI_DIMENSION);
		menuBuilder.setPreferredSize(Map_Settings.GUI_DIMENSION);
		settingsJPanel.setBackground(Color.GREEN);
		settingsJPanel.setPreferredSize(Map_Settings.GUI_DIMENSION);
		settingsJPanel.setLayout(GUILayout);
		
		eventBuilder = new EventBuilder();
		
	}
	
	public void initMenu() throws IOException, InterruptedException{
		GridBagConstraints menuContrains = new GridBagConstraints();
		
		//menuContrains.fill = menuContrains.HORIZONTAL;
		menuContrains.gridwidth = GridBagConstraints.REMAINDER;
		menuContrains.gridheight = 1;
		menuContrains.insets = new Insets(100, 15, 15, 0);
		ImageIcon imageIcon = new ImageIcon("assets/images/test.png");
		JButton play = new JButton("Play");
		JButton settings = new JButton(imageIcon);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		JButton exit = new JButton("Exit");
			
		play.addActionListener(new Play());
		settings.addActionListener(new Settings());
		exit.addActionListener(new Exit());
		
		menuJPanel.add(play, menuContrains);
		menuJPanel.add(settings, menuContrains);
		menuJPanel.add(exit, menuContrains);
		initSettings();
		
		mapContent.add(menuJPanel);
		menuVisible();
		
	}
	
	public void initSettings() {
		FlowLayout settingsLayout = new FlowLayout();
		
		JLabel nbBeasts = new JLabel("Number of Beasts :");
		JTextField nbBeastsField = new JTextField(10);
		JButton beastConfirm = new JButton("Confirm");
		JPanel nbBeastPanel = new JPanel();
		nbBeastPanel.setLayout(settingsLayout);
		
		nbBeastPanel.add(nbBeasts);
		nbBeastPanel.add(nbBeastsField);
		nbBeastPanel.add(beastConfirm);
		nbBeastPanel.setOpaque(false);
		
		
		
		settingsJPanel.add(nbBeastPanel);
		mapContent.add(settingsJPanel);
	}
	
	
	
	
	public void initMapPanel() {
		this.setContentPane(this.getContentPane());
		//setRandomMap(width of the map, length)
		mapPanel = mapBuilder.setRandomMap(mapPanel);
		mapPanel = mapBuilder.setRandomBeasts(mapPanel);
		mapPanel = mapBuilder.setTileImages(mapPanel);
		for (int i=0;i<Map_Settings.nbBeasts;i++) {
			mapPanel.getBeastPanel().get(i).setBeastImage();
		}
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
/**/	//mapJPanel.setVisible(false);
	}
	
	public void packLayout() {
		
		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void mapVisible() {
		if(menuJPanel.isVisible()) menuJPanel.setVisible(false);
		if(!mapJPanel.isVisible())mapJPanel.setVisible(true);
		if(settingsJPanel.isVisible()) settingsJPanel.setVisible(false);
	}
	
	public void menuVisible() {
		if(!menuJPanel.isVisible()) menuJPanel.setVisible(true);
		if(mapJPanel.isVisible())mapJPanel.setVisible(false);
		if(settingsJPanel.isVisible()) settingsJPanel.setVisible(false);
	}
	
	public void settingsVisible() {
		
		if(mapJPanel.isVisible())mapJPanel.setVisible(false);
		if(menuJPanel.isVisible()) menuJPanel.setVisible(false);
		if(!settingsJPanel.isVisible()) settingsJPanel.setVisible(true);
	}
	
	
	class Play implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			try {
				initMap();
				packLayout();
				mapVisible();
			} catch (IOException | InterruptedException e1) {e1.printStackTrace();}
		}
	}
	
	class Settings implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			settingsVisible();
				
		}
	}
	
	class Exit implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}
	}
	
	
}
