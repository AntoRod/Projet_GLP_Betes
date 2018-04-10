package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import core.*;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import data.*;
public class GraphicalMap2 extends JFrame{
	
	private static final long serialVersionUID = 15601560412569849L;
	
	private Container mapContent = null;
	private MapPanel mapPanel;
	private MapBuilder mapBuilder;
	private JPanel mapJPanel;
	private JPanel mapInfos;
	private Moving movement;
	private Fighting fight;
	private Treatment treatment;
	private ArrayList<Location> foodLocation;
	
	private JLabel tileLocation;
	private JTextArea beastInformations;
	private int selectedAbsciss;
	private int selectedOrdinate;
	
	private Boolean pausedGame;
	private JButton pause;
	private JButton play;
	
	public GraphicalMap2(){
		this("[ALPHA 0.0.1] Civilization VII");
	}
	
	public GraphicalMap2(String title){
		
		super(title);
		try {
			initMap();
			playGame();
		} catch(IOException | InterruptedException e) {e.getMessage();}
		
	}
	
	public void playGame() throws InterruptedException {
		movement = new Moving();
		treatment = new Treatment();
		while(Map_Settings.SIMULATION_TURNS>0) {
			Thread.sleep(Map_Settings.GAME_PAUSE);
			if(pausedGame == false) {
				if(selectedAbsciss!=-1 && selectedOrdinate!=-1) {
					this.actualizeField(mapPanel.getTilePanel(selectedAbsciss,selectedOrdinate), mapPanel.getBeastPanel(), mapPanel.getFoodPanel());
				}
				for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
					for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
						int beastPerTile = treatment.analyseTile(mapPanel.getTilePanel(i,  j), mapPanel.getBeastPanel());
						//if(beastPerTile>=2) {
						//	Image fightImage = Toolkit.getDefaultToolkit().getImage("assets/images/fight.png");
						//	mapPanel.getTilePanel(i,  j).setBeastImage(fightImage);
							//ACTIONS NOT REQUIRED CAUSE ALREADY HANDLED IN TREATMENT BUT LATER WILL BE
	//							System.out.println("Case: "+mapPanel.getTile(i,  j).getLocation()+" nombre de Betes: "+beastPerTile);
						//}
					}
				}
				
				
//				System.out.println("TOTAL BEASTS: "+Map_Settings.TOTAL_BEASTS+"\n");
				for(int i=0;i<Map_Settings.nbBeasts;i++) {
					
					if(mapPanel.getBeast(i).canMove()) {
						//System.out.println("Number:"+mapPanel.getBeast(i)+" "+mapPanel.getBeast(i).canMove()+"\n");
						movement.Move(mapPanel.getTilesPanel(), mapPanel.getBeastPanel(i));
						int abcsiss = mapPanel.getBeast(i).getAbsciss();
						int ordinate = mapPanel.getBeast(i).getOrdinate();
						for(int j=0;j<mapPanel.getFoodPanel().size();j++) {
							if(mapPanel.getFoodPanel().get(j).getLocation().getAbsciss()==abcsiss && mapPanel.getFoodPanel().get(j).getLocation().getOrdinate()== ordinate) {
								treatment.eatFood(mapPanel.getBeast(i), mapPanel.getFoodPanel().get(j), mapPanel.getTile(abcsiss,  ordinate));
							}
						}
					}
				
				}
				
				this.resetBeastImages();
				this.resetImages();
				repaint();
				
			}
			Map_Settings.decrementTurns();
		}
	}
	
	
	
	public void initMap() throws IOException, InterruptedException {

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
		initMapInfos();
		selectedAbsciss = -1;
		selectedOrdinate = -1;
		pausedGame = true;
		
		this.pack();
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		
	}
	
	
	public void initMapPanel() {
		//this.setContentPane(this.getContentPane());
		mapBuilder = new MapBuilder(mapPanel);
		mapPanel = new MapPanel();
		//setRandomMap(width of the map, length)
		mapPanel = mapBuilder.setRandomMap(mapPanel);
		mapPanel = mapBuilder.setRandomBeasts(mapPanel);
		mapPanel = mapBuilder.setTileImages(mapPanel);
		for (int i=0;i<Map_Settings.nbBeasts;i++) {
			if(!mapPanel.getBeast(i).isDead()) mapPanel.getBeastPanel().get(i).setBeastImage();
			
		}
		mapPanel = mapBuilder.setBeastImages(mapPanel);
		foodLocation = new ArrayList<Location>();
		getFoodLocations();
		
		
	}
	
	public void addMapPanel() {
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				//mapContent.add(mapPanel.getTilePanel(i,j));
				mapJPanel.add(mapPanel.getTilePanel(i,  j), i*Map_Settings.MAP_WIDTH+j);
				mapJPanel.getComponent(i*Map_Settings.MAP_WIDTH+j).addMouseListener(new seeDetails(mapPanel.getTilePanel(i,  j), mapPanel.getBeastPanel()));
			}
		}
		mapContent.add(mapJPanel);
	}
	
	
	public void initMapInfos() {
		mapInfos = new JPanel();
		mapInfos.setPreferredSize(new Dimension(Map_Settings.MAPINFOS_WIDTH, Map_Settings.MAPINFOS_LENGTH));
		GridBagLayout mapInfosLayout = new GridBagLayout();
		GridBagConstraints mapInfosConstrains = new GridBagConstraints();
		mapInfosConstrains.gridwidth = GridBagConstraints.REMAINDER;
		mapInfosConstrains.gridheight = 1;
		
		FlowLayout infosLayout = new FlowLayout();
		JPanel tileInfos = new JPanel();
		tileInfos.setLayout(infosLayout);
		
		JLabel tileInfo = new JLabel("Tile Informations: ");
		tileLocation = new JLabel("No tile selected");
		tileInfos.add(tileInfo);
		tileInfos.add(tileLocation);
		
		JPanel beastInfos = new JPanel();
		beastInfos.setLayout(infosLayout);
		beastInformations = new JTextArea("No beast selected");
		beastInformations.setEditable(false);
		beastInformations.setPreferredSize(new Dimension(110,20));
		
		ImageIcon slowIcon = new ImageIcon("assets/images/slowButton.png");
		ImageIcon speedIcon = new ImageIcon("assets/images/speedButton.png");
		ImageIcon exitIcon = new ImageIcon("assets/images/exitButton.png");
		ImageIcon pauseIcon = new ImageIcon("assets/images/pauseButton.png");
		ImageIcon playIcon = new ImageIcon("assets/images/playButton.png");
		
		JPanel gameButtons = new JPanel();
		gameButtons.setLayout(infosLayout);
		
		JButton slow = new JButton(slowIcon);
		slow.addActionListener(new slowGame());
		slow.setContentAreaFilled(false);
		slow.setBorderPainted(false);
		slow.setBorder(BorderFactory.createEmptyBorder());
		
		JButton speed = new JButton(speedIcon);
		speed.addActionListener(new speedGame());
		speed.setContentAreaFilled(false);
		speed.setBorderPainted(false);
		speed.setBorder(BorderFactory.createEmptyBorder());
		
		pause = new JButton(pauseIcon);
		pause.addActionListener(new pauseGame());
		pause.setContentAreaFilled(false);
		pause.setBorderPainted(false);
		pause.setBorder(BorderFactory.createEmptyBorder());
		pause.setVisible(false);
		
		play = new JButton(playIcon);
		play.addActionListener(new pauseGame());
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setBorder(BorderFactory.createEmptyBorder());
		
		JButton exit = new JButton(exitIcon);
		exit.addActionListener(new Exit());
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setBorder(BorderFactory.createEmptyBorder());
		
		
		gameButtons.add(slow);
		gameButtons.add(pause);
		gameButtons.add(play);
		gameButtons.add(speed);
		gameButtons.add(exit);
		
		//ADD THE COMPONENTS
		beastInfos.add(beastInformations);
		mapInfos.setBackground(Color.BLUE);
		mapInfos.setLayout(mapInfosLayout);
		mapInfos.add(gameButtons, mapInfosConstrains);
		mapInfos.add(tileInfos, mapInfosConstrains);
		mapInfos.add(beastInfos, mapInfosConstrains);

		mapContent.add(mapInfos);
		
	}
	
	public void resetBeastImages() {
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				mapPanel.getTilePanel(i,  j).setBeastImage(null);
			}
		}
		for (int h=0;h<Map_Settings.nbBeasts;h++) {
			mapPanel.getBeastPanel(h).setBeastImage();
		}
		mapPanel = mapBuilder.setBeastImages(mapPanel);
	}
	public void getFoodLocations() {
		int absciss;
		int ordinate;
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				if(mapPanel.getTile(i,  j).containsFood()) {
					absciss = mapPanel.getTile(i,  j).getAbsciss();
					ordinate = mapPanel.getTile(i,  j).getOrdinate();
					Location foodLoc = new Location(i, j);
					System.out.println(foodLoc.toString()+"\n");
					foodLocation.add(foodLoc);
				}
			}
		}
	}
	
	public void resetImages() {
		int abcsiss = -1;
		int ordinate = -1;
		TilePanel tilePanel;
		for (int i=0;i<Map_Settings.MAP_WIDTH;i++) {
			for (int j=0;j<Map_Settings.MAP_LENGTH;j++) {
				for(int h=0;h<foodLocation.size();h++) {
					abcsiss = foodLocation.get(h).getAbsciss();
					ordinate = foodLocation.get(h).getOrdinate();
					tilePanel = mapPanel.getTilePanel(i,  j);
					if(tilePanel.getTile().getAbsciss()==abcsiss && tilePanel.getTile().getOrdinate()==ordinate) {
						Image image = Toolkit.getDefaultToolkit().getImage("assets/tiles/"+tilePanel.getTile().getBiome().getBiomeType()+"_1.png");
						if(!tilePanel.getTile().containsFood()) tilePanel.setTileImage(image);
					}
				}
			}
		}

	}
	
	
	
	class slowGame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Map_Settings.slowTime();
		}
	}
	class speedGame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Map_Settings.speedTime();
		}
	}
	
	class pauseGame implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			if(pausedGame == true) {
				pausedGame = false;
				play.setVisible(false);
				pause.setVisible(true);
			}
			else {
				pausedGame = true;
				play.setVisible(true);
				pause.setVisible(false);
			}
			
			
		}
	}
	
	class Exit implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	class seeDetails implements MouseListener {

		TilePanel tilePanel;
		ArrayList<BeastPanel> beastsPanel;
		public seeDetails(TilePanel tPanel, ArrayList<BeastPanel> bPanel) {
			tilePanel = tPanel;
			beastsPanel = bPanel;
		}
		
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
			    selectedAbsciss = tilePanel.getTile().getAbsciss();
				selectedOrdinate = tilePanel.getTile().getOrdinate();
			    actualizeField(tilePanel, beastsPanel, mapPanel.getFoodPanel());
			  }
			else if(e.getClickCount()<2) {
				tileLocation.setText("No tile selected");
				beastInformations.setText("No beast selected");
				beastInformations.setPreferredSize(new Dimension(110,20));
				selectedAbsciss = -1;
				selectedOrdinate = -1;
			}
		}

		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}
	
	
	public void actualizeField(TilePanel tilePanel, ArrayList<BeastPanel> beastsPanel, ArrayList<Food> foodPanel) {
		int absciss = tilePanel.getTile().getAbsciss();
		int ordinate = tilePanel.getTile().getOrdinate();
		int foodIndex = -1;
		for(int i=0;i<foodPanel.size();i++) {
			if(foodPanel.get(i).getLocation().getAbsciss()==absciss && foodPanel.get(i).getLocation().getOrdinate()==ordinate) foodIndex = i;
		}
		if(tilePanel.getTile().containsFood()) {
			tileLocation.setText("X: "+tilePanel.getTile().getAbsciss()+" Y "
					+tilePanel.getTile().getOrdinate()+" Obstacle: "
					+tilePanel.getTile().isObstacle()+" Fighting: "
					+tilePanel.getTile().isFighting()+" Food: "
					+foodPanel.get(foodIndex).getFoodValue());
		}
		else {
			tileLocation.setText("X: "+tilePanel.getTile().getAbsciss()+" Y "
					+tilePanel.getTile().getOrdinate()+" Obstacle: "
					+tilePanel.getTile().isObstacle()+" Fighting: "
					+tilePanel.getTile().isFighting()+" Food: 0");
		}

		
		int beastNumber;
		if(tilePanel.getTile().isFighting() || tilePanel.getTile().isCopulating()) {
			int firstNumber = tilePanel.getFirst();
			int secondNumber = tilePanel.getSecond();
			Beast firstBeast = beastsPanel.get(firstNumber).getBeast();
			Beast secondBeast = beastsPanel.get(secondNumber).getBeast();
			beastInformations.setPreferredSize(new Dimension(350,80));
			beastInformations.setText("First Beast informations:	|  Second Beast informations: "
			+ "\n"+firstBeast.getStats().getAttack() + "	|  "+ secondBeast.getStats().getAttack()
			+ "\n"+ firstBeast.getStats().getDefense() + "	|  "+ secondBeast.getStats().getDefense()
			+ "\n"+ firstBeast.getStats().stringLivePoints() + "	|  "+ secondBeast.getStats().stringLivePoints()
			+ "\n"+ firstBeast.getStats().stringStamina() + "	|  "+ secondBeast.getStats().stringStamina()
			);
		}
		/*else if(tilePanel.getTile().isCopulating()) {
			
		}*/
		else if((beastNumber=tilePanel.containsBeast(beastsPanel))>0) {
			Beast beast = beastsPanel.get(beastNumber).getBeast();
			beastInformations.setPreferredSize(new Dimension(160,80));
			beastInformations.setText("Beast Informations: "
			+"\n"+beast.getStats().getAttack()
			+"\n"+beast.getStats().getDefense()
			+"\n"+beast.getStats().stringLivePoints()
			+"\n"+beast.getStats().stringStamina()
			);
		}
		else {
			beastInformations.setText("No beast selected");
			beastInformations.setPreferredSize(new Dimension(110,20));
		}
	}
	
	
	
	
	

}

