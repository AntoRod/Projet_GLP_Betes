package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.BorderFactory;
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
	private JPanel mapJPanel = null;
	private JPanel menuJPanel = null;
	private JPanel settingsJPanel = null;
	private Moving movement;
	TextZone nbBeastsField ;
	TextZone mapWidthField ;
	TextZone mapLengthField ;
	
	public GraphicalMap3() throws InterruptedException {
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap3(String title) throws InterruptedException {
		super(title);
		
		try {
			//initialisation of the panels/containers/layouts
			initMenuComponents();
			
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
		

		initMapComponents();
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
	
	
	public void initMenuComponents() {
		GridBagLayout GUILayout = new GridBagLayout();
		
		mapContent = getContentPane();
		mapContent.setPreferredSize(Map_Settings.GUI_DIMENSION);
		mapContent.setLayout(GUILayout);
		
		menuBuilder = new MenuBuilder();
		menuJPanel = new JPanel();
		settingsJPanel = new JPanel();
		mapJPanel = new JPanel();
		mapPanel = new MapPanel();
		mapBuilder = new MapBuilder(mapPanel);
		
		//menuJPanel.setBackground(Color.RED);
		menuJPanel.setLayout(GUILayout);
		menuJPanel.setPreferredSize(Map_Settings.GUI_DIMENSION);
		menuBuilder.setPreferredSize(Map_Settings.GUI_DIMENSION);
		//settingsJPanel.setBackground(Color.GREEN);
		settingsJPanel.setPreferredSize(Map_Settings.GUI_DIMENSION);
		settingsJPanel.setLayout(GUILayout);
		
	}
	
	public void initMapComponents () {
		GridLayout MapLayout = new GridLayout(Map_Settings.MAP_WIDTH, Map_Settings.MAP_LENGTH);
		
		mapContent.setPreferredSize(Map_Settings.GUI_DIMENSION);
		mapJPanel.setPreferredSize(Map_Settings.MAP_DIMENSION);
		mapJPanel.setLayout(MapLayout);
		
	}
	
	public void initMenu() throws IOException, InterruptedException{
		
		//this.setContentPane(menuBuilder.getContentPane());
		//this.setContentPane(menuBuilder);
	
		GridBagConstraints menuContrains = new GridBagConstraints();
		
		//menuContrains.fill = menuContrains.HORIZONTAL;
		menuContrains.gridwidth = GridBagConstraints.REMAINDER;
		menuContrains.gridheight = 1;
		menuContrains.insets = new Insets(20, 0, 0, 0);
		
		ImageIcon startButton = new ImageIcon("assets/images/Start.png");
		ImageIcon settingsButton = new ImageIcon("assets/images/Settings.png");
		ImageIcon exitButton = new ImageIcon("assets/images/Exit.png");

		JButton play = new JButton(startButton);
		JButton settings = new JButton(settingsButton);
		JButton exit = new JButton(exitButton);
		
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setBorder(BorderFactory.createEmptyBorder());
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBorder(BorderFactory.createEmptyBorder());
		
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
		GridBagLayout settingsLayout = new GridBagLayout();
		GridBagConstraints settingsContrains = new GridBagConstraints();
		settingsContrains.gridwidth = GridBagConstraints.REMAINDER;
		settingsContrains.gridheight = 5;
		
		Font settingsFont = new Font("BOLD",Font.BOLD, 40);
		
		JLabel nbBeasts = new JLabel("Number of Beasts :");
		nbBeasts.setFont(settingsFont);
		nbBeastsField = new TextZone(5, settingsFont);
		nbBeastsField.setToolTipText("Max: 5% of the MAP SIZE");
		JPanel nbBeastPanel = new JPanel();
		nbBeastPanel.setLayout(settingsLayout);
		nbBeastPanel.add(nbBeasts);
		nbBeastPanel.add(nbBeastsField);
		ConfirmButton confirmBeasts = new ConfirmButton();
		confirmBeasts.addActionListener(new ValidateNbBeasts());
		nbBeastPanel.add(confirmBeasts);
		nbBeastPanel.setOpaque(false);
		
		JLabel mapWidth = new JLabel("Width of the Map :");
		mapWidth.setFont(settingsFont);
		mapWidthField = new TextZone(5, settingsFont);
		mapWidthField.setToolTipText("Max: 30");
		JPanel mapWidthPanel = new JPanel();
		mapWidthPanel.setLayout(settingsLayout);
		mapWidthPanel.add(mapWidth);
		mapWidthPanel.add(mapWidthField);
		ConfirmButton confirmWidth = new ConfirmButton();
		confirmWidth.addActionListener(new ValidateWidth());
		mapWidthPanel.add(confirmWidth);
		mapWidthPanel.setOpaque(false);
		mapLengthField = new TextZone(5, settingsFont);
		mapLengthField.setToolTipText("Max: 30");
		JLabel mapLength = new JLabel("Length of the Map :");
		mapLength.setFont(settingsFont);

		JPanel mapLengthPanel = new JPanel();
		mapLengthPanel.setLayout(settingsLayout);
		mapLengthPanel.add(mapLength);
		mapLengthPanel.add(mapLengthField);
		ConfirmButton confirmLength = new ConfirmButton();
		confirmLength.addActionListener(new ValidateLength());
		mapLengthPanel.add(confirmLength);
		mapLengthPanel.setOpaque(false);
	
		ImageIcon backButton = new ImageIcon("assets/images/Back.png");
		JButton back = new JButton(backButton);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new BackToMenu());
		
		settingsJPanel.add(mapWidthPanel, settingsContrains);
		settingsJPanel.add(mapLengthPanel, settingsContrains);
		settingsJPanel.add(nbBeastPanel, settingsContrains);
		settingsJPanel.add(back, settingsContrains);
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
		if(!mapJPanel.isVisible()) mapJPanel.setVisible(true);
		if(settingsJPanel.isVisible()) settingsJPanel.setVisible(false);

	}
	
	public void menuVisible() {
		if(!menuJPanel.isVisible()) menuJPanel.setVisible(true);
		if(mapJPanel.isVisible()) mapJPanel.setVisible(false);
		if(settingsJPanel.isVisible()) settingsJPanel.setVisible(false);

	}
	
	public void settingsVisible() {
		if(menuJPanel.isVisible()) menuJPanel.setVisible(false);
		if(mapJPanel.isVisible()) mapJPanel.setVisible(false);
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
	
	class BackToMenu implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			menuVisible();
		}
	}
	
	class ValidateNbBeasts implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int number = Integer.parseInt(nbBeastsField.getText()); 
			Map_Settings.setNbBeasts(number);
			System.out.print(Map_Settings.nbBeasts+"\n");
		}
	}
	
	class ValidateWidth implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int number = Integer.parseInt(mapWidthField.getText()); 
			Map_Settings.setMapWidth(number);
			System.out.print(Map_Settings.MAP_WIDTH+"\n");
		}
	}
	class ValidateLength implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int number = Integer.parseInt(mapLengthField.getText()); 
			Map_Settings.setMapLength(number);
			System.out.print(Map_Settings.MAP_LENGTH+"\n");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image test = Toolkit.getDefaultToolkit().getImage("assets/images/menu.jpg");
		g.drawImage(test, 0, 0, this);
	}
	
	
}
