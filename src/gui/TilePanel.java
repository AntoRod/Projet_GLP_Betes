package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.Tile;

public class TilePanel extends JPanel{
	
	private static final long serialVersionUID = -2031078202709262937L;
	
	private Tile tile;
	private Image tileImage = null;
	private Image beastImage = null;
	
	private int firstBeastNumber;
	private int secondBeastNumber;

	public TilePanel(){
		tile = new Tile();
		firstBeastNumber = -1;
		secondBeastNumber = -1;
	}
	public TilePanel(int biomeNumber) {
		tile = new Tile(biomeNumber);
	}
	public TilePanel(int biomeNumber, Boolean obstacle) {
		tile = new Tile(biomeNumber, obstacle);
	}
	
	public void setTile(Tile tileSet) {
		tile = tileSet;
	}
	
	public Tile getTile() {
		return tile;
	}

	public int getFirst() {
		return firstBeastNumber;
	}
	public int getSecond() {
		return secondBeastNumber;
	}
	
	public void setFirst(int firstNumber) {
		firstBeastNumber = firstNumber;
	}
	public void setSecond(int secondNumber) {
		secondBeastNumber = secondNumber;
	}
	
	public void setTileImage(Image image) {
		tileImage = image;
	}
	
	
	public void setTileImage() {
		Image image = null;
		String imagePath = "assets/tiles/";
		//generate number of variants (1-8)
		int imageNumber = Map_Settings.generateRand(1,8);
		imagePath+=tile.getBiome().getBiomeType();
		if(tile.containsFood()) {
			imagePath+="_food.png";
		}
		
		else{
			if(tile.isObstacle()) imagePath+="_obstacle";
			imagePath+="_"+imageNumber+".png";
		}
		
		
		image = Toolkit.getDefaultToolkit().getImage(imagePath);
//		System.out.println(imagePath+"\n");
		tileImage = image;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//safe color map, if we can't find the images
		g.setColor(tile.getBiome().getColor());
		//fill the panel with biome colors
		g.fillRect(0,0, Map_Settings.CASE_WIDTH, Map_Settings.CASE_WIDTH);
		//define the image of the tile and draw it in the panel
		this.setBeastImage(beastImage);
		g.drawImage(tileImage, 0, 0, this);
		g.drawImage(beastImage, 0,0, this);
	}
	
	public void setBeastImage(Image beast) {
		beastImage = beast;
	}
	
	public void resetBeastImage() {
		beastImage = null;
	}
	
	public int containsBeast(ArrayList<BeastPanel> beastsPanel) {
		int absciss = tile.getAbsciss();
		int ordinate = tile.getOrdinate();
		for(int i=0;i<Map_Settings.nbBeasts;i++) {
			int beastAbcsiss = beastsPanel.get(i).getBeast().getAbsciss();
			int beastOrdinate = beastsPanel.get(i).getBeast().getOrdinate();
			if(beastAbcsiss==absciss && beastOrdinate==ordinate) {
				
				return beastsPanel.get(i).getBeast().getNumber();
			}
		}
		return -1;
		
	}
	
	
	
}
